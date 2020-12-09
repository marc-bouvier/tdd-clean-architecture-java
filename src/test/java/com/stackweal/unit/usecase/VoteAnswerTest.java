package com.stackweal.unit.usecase;

import com.stackweal.adapters.InMemoryVoteRepository;
import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;
import com.stackweal.hexagone.usecases.VoteAnswer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class VoteAnswerTest {

    InMemoryVoteRepository voteRepository = new InMemoryVoteRepository();

    @Test
    void shouldVoteForAnExistingAnswer(){
        String answerId = "333abc";
        voteRepository.feed(answerId,0);
        new VoteAnswer(voteRepository).handle(answerId);
//        // Le domaine doit toujours parler UUID
//        // Dans la vraie vie, ce qui est lecture ne passe pas par un repo
        assertThat(voteRepository.byAnswerId(answerId)).isEqualTo(new Vote(answerId,1)); // une seule réponse pour le moment (micro-test)
    }
}
