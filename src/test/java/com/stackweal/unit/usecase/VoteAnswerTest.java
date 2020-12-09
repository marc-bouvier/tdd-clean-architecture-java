package com.stackweal.unit.usecase;

import com.stackweal.adapters.InMemoryVoteRepository;
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
                new VoteAnswer(voteRepository).handle(answerId);
//        // Le domaine doit toujours parler UUID
//        // Dans la vraie vie, ce qui est lecture ne passe pas par un repo
                assertThat(voteRepository.byAnswerId(answerId)).isEqualTo(new Vote(answerId, 1)); // une seule réponse pour le moment (micro-test)
            }
        }

        @Nested
        class ExistingVote {
            @Test
            void shouldVoteForIt() {

                feedVotes(answerId, 1);
                new VoteAnswer(voteRepository).handle(answerId);
//        // Le domaine doit toujours parler UUID
//        // Dans la vraie vie, ce qui est lecture ne passe pas par un repo
                assertThat(voteRepository.byAnswerId(answerId)).isEqualTo(new Vote(answerId, 2)); // une seule réponse pour le moment (micro-test)
            }
        }
    }

    private void feedVotes(String answerId, int value) {
        voteRepository.feed(answerId, value);
    }

}
