package com.stackweal.hexagone.usecases;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

public class VoteAnswer {

    private VoteRepository voteRepository;

    public VoteAnswer(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public void handle(String answerId) {
        Vote vote = voteRepository.byAnswerId(answerId);
        vote.increment();
//        voteRepository.save(answerId,vote);

    }
}
