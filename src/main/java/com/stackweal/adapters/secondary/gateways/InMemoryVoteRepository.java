package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

import java.util.HashMap;
import java.util.Map;

public class InMemoryVoteRepository implements VoteRepository {
    private final Map<String, Vote> votes = new HashMap<>();


    @Override
    public Vote byAnswerId(String answerId) {
        return votes.get(answerId);
    }

//    @Override
//    public void save(String answerId, Vote vote) {
//        votes.put(answerId,vote);
//    }

    public void feed(String answerId, int i) {
        votes.put(answerId, new Vote(answerId, i));
    }
}
