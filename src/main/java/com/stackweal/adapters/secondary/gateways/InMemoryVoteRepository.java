package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

import java.util.*;

public class InMemoryVoteRepository implements VoteRepository {
    private final Map<String, Set<Vote>> votes = new HashMap<>();


    @Override
    public Optional<Vote> byIds(String visitorId, String answerId) {


        Set<Vote> answerVotes = votes.get(answerId);
        if(answerVotes==null){
            return Optional.empty();
        }
        return answerVotes.stream()
                .filter(vote -> vote.author(visitorId)).findFirst();
    }

    @Override
    public void save(Vote vote) {
     votes.put(vote.getAnswerId(), Collections.singleton(vote));
    }

}
