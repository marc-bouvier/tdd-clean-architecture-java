package com.stackweal.unit.usecase;

import com.stackweal.adapters.secondary.gateways.InMemoryVoteRepository;
import com.stackweal.hexagone.models.Vote;
import com.stackweal.hexagone.usecases.VoteAnswer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class VoteAnswerTest {

    private final InMemoryVoteRepository voteRepository = new InMemoryVoteRepository();
    private final String answerId = "333abc";
    private String brunoVisitorId = "777abc";
    private String cecileVisitorId = "888abc";

    @Nested
    class ExistingAnswer {

        @Nested
        class NoExistingVote {
            @Test
            void shouldVoteForItForTheFirstTime() {

                vote(brunoVisitorId);
                assertAnswerVote(brunoVisitorId, answerId);
            }
        }

        @Nested
        class ExistingVoteFromAnotherAuthor {
            @Test
            void shouldBeAbleToVoteForIt() {
                existingVote(answerId, brunoVisitorId);
                vote(cecileVisitorId);
                assertAnswerVote(cecileVisitorId, answerId);
            }
        }

    }

    private void existingVote(String answerId, String visitorId) {
        voteRepository.existingVote(answerId, visitorId);
    }

    private void assertAnswerVote(String visitorId, String answerId) {
        assertThat(voteRepository.byIds(visitorId, answerId))
                .isEqualTo(Optional.of(new Vote(answerId, visitorId))); // une seule réponse pour le moment (micro-test)
    }

    private void vote(String visitorId) {

        new VoteAnswer(voteRepository).handle(visitorId, answerId);
    }

}
