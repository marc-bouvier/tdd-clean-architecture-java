package com.stackweal.hexagone.usecases;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

/**
 * An use case is the entry point of the domain.
 * It should not depend on frameworks. Only rely on domain classes and ports.
 */
public class VoteAnswer {

    private final VoteRepository voteRepository;

    public VoteAnswer(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public void handle(String visitorId, String answerId) {
//        Vote vote = voteRepository.byIds(visitorId,answerId);
        voteRepository.save(new Vote(answerId, visitorId));

    }
}