package com.stackweal.unit.usecase;

import com.stackweal.adapters.secondary.gateways.InMemoryVoteRepository;
import com.stackweal.hexagone.models.Vote;
import com.stackweal.hexagone.usecases.VoteAnswer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VoteAnswerTest {

    private final InMemoryVoteRepository voteRepository = new InMemoryVoteRepository();
    private final String answerId = "333abc";

    @Nested
    class ExistingAnswer {

        @Nested
        class NoExistingVote {
            @Test
            void shouldVoteForIt() {

                feedVotes(answerId, 0);
                vote();
                assertAnswerVote(1);
            }
        }

        @Nested
        class ExistingVote {
            @Test
            void shouldVoteForIt() {

                feedVotes(answerId, 1);
                vote();
                assertAnswerVote(2);
            }
        }

    }

    private void feedVotes(String answerId, int value) {
        voteRepository.feed(answerId, value);
    }

    private void assertAnswerVote(int expectedValue) {
        assertThat(voteRepository.byAnswerId(answerId)).isEqualTo(new Vote(answerId, expectedValue)); // une seule réponse pour le moment (micro-test)
    }

    private void vote() {
        new VoteAnswer(voteRepository).handle(answerId);
    }

}
