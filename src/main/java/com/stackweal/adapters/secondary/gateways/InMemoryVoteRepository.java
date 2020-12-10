package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryVoteRepository implements VoteRepository {
    private final Map<String, List<Vote>> votes = new HashMap<>();


    @Override
    public List<Vote> byIds(String answerId, String visitorId) {

        List<Vote> votes = this.votes.get(answerId);
        if (votes == null) {
            return Collections.emptyList();
        }
        return votes.stream()
                .filter(vote -> vote.author(visitorId))
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasNeverVotedYet(String answerId, String visitorId) {
        return byIds(answerId, visitorId).isEmpty();

    }

    @Override
    public void save(Vote vote) {
        List<Vote> visitorVotes = this.byIds(vote.getAnswerId(), vote.getVisitorId());
        if (visitorVotes == null) {
            votes.put(vote.getAnswerId(), Collections.singletonList(vote));
        } else {
            List<Vote> newVisitorVotes = new ArrayList<>(visitorVotes);
            newVisitorVotes.add(vote);

            votes.put(vote.getAnswerId(), newVisitorVotes);
        }
    }

    public void existingVote(String answerId, String visitorId) {
        this.save(new Vote(answerId, visitorId));
    }
}
