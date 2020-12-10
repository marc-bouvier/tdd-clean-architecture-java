package com.stackweal.unit.usecase;

import com.stackweal.adapters.secondary.gateways.InMemoryAnswerRepository;
import com.stackweal.adapters.secondary.gateways.InMemoryVoteRepository;
import com.stackweal.adapters.secondary.gateways.PassiveTransactionPerformer;
import com.stackweal.hexagone.gateways.AnswerRepository;
import com.stackweal.hexagone.gateways.TransactionPerformer;
import com.stackweal.hexagone.models.Answer;
import com.stackweal.hexagone.models.Vote;
import com.stackweal.hexagone.usecases.VoteAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VoteAnswerTest {

    private final InMemoryVoteRepository voteRepository = new InMemoryVoteRepository();
    private final AnswerRepository answerRepository = new InMemoryAnswerRepository();
    private TransactionPerformer transactionPerformer = new PassiveTransactionPerformer();
    private final String answerId = "333abc";
    private String brunoVisitorId = "777abc";
    private String cecileVisitorId = "778def";

    @Nested
    class NotFoundAnswer {

        @Test
        void shouldNotBeAbleToVote() {
            vote(brunoVisitorId);
            assertThat(voteRepository.myVotes(answerId, brunoVisitorId)).isEmpty();
        }
    }


    @Nested
    class ExistingAnswer {

        @BeforeEach
        void SetUp() {
            answerRepository.existingAnswers(new Answer(answerId));
        }

        @Nested
        class NoExistingVote {

            @Test
            void shouldVoteForItForTheFirstTime() {
                vote(brunoVisitorId);
                assertAnswerVotes(answerId, brunoVisitorId);
            }

            @Test
            void shouldPerformTheUseCaseInATransaction() {
                // By having a trasactions that suppress the execution of the behaviour tested
                // we deduce by negation that transaction wraps use case or not
                transactionPerformer = new NullTransaction();
                vote(brunoVisitorId);
                assertThat(voteRepository.myVotes(answerId, brunoVisitorId)).isEmpty();
            }

        }

        @Nested
        class ExistingVoteFromAnotherAuthor {

            @Test
            void shouldBeAbleToVoteForIt() {
                existingVote(answerId, brunoVisitorId);
                vote(cecileVisitorId);
                assertAnswerVotes(answerId, cecileVisitorId, brunoVisitorId);

            }

        }

        @Nested
        class ExistingVoteFromMyBehalf {

            @Test
            void shouldNotBeAbleToVoteForIt() {
                existingVote(answerId, brunoVisitorId);
                vote(brunoVisitorId);
                assertAnswerVotes(answerId, brunoVisitorId);
            }

        }

    }

    private void existingVote(String answerId, String visitorId) {
        voteRepository.setExistingVote(answerId, visitorId);
    }

    private void vote(String visitorId) {
        new VoteAnswer(voteRepository, answerRepository, transactionPerformer).handle(visitorId, answerId);
    }

    private void assertAnswerVotes(String answerId, String... visitorIds) {
        List<Vote> fetchedVotes = new ArrayList<>();
        for (var visitorId : visitorIds) {
            fetchedVotes.addAll(voteRepository.myVotes(answerId, visitorId));
        }
        var expectedVotes = new ArrayList<>();
        for (String visitorId : visitorIds) {
            expectedVotes.add(new Vote(answerId, visitorId));
        }
        assertThat(fetchedVotes).isEqualTo(expectedVotes);
    }

}

class NullTransaction implements TransactionPerformer {

    @Override
    public void execute(Runnable useCaseCode) {

    }
}
