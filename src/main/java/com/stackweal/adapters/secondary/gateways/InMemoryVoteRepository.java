package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryVoteRepository implements VoteRepository {

    private final Map<String, List<Vote>> votes = new HashMap<>();

    @Override
    public boolean hasNeverVotedYet(String answerId, String visitorId) {
        return myVotes(answerId, visitorId).isEmpty();
    }

    @Override
    public void save(Vote vote) {
        List<Vote> visitorVotes = myVotes(vote.getAnswerId(), vote.getVisitorId());
        if (visitorVotes == null)
            votes.put(vote.getAnswerId(), Collections.singletonList(vote));
        else {
            List<Vote> existingVotes = votes.get(vote.getAnswerId());
            List<Vote> newVisitorVotes = new ArrayList<>();
            if (existingVotes != null)
                newVisitorVotes.addAll(existingVotes);
            newVisitorVotes.add(vote);
            votes.put(vote.getAnswerId(), newVisitorVotes);
        }
    }

    /**
     * @apiNote not production code.
     */
    public void setExistingVote(String answerId, String visitorId) {
        this.save(new Vote(answerId, visitorId));
    }

    /**
     * @apiNote not production code.
     */
    public List<Vote> myVotes(String answerId, String visitorId) {
        List<Vote> answerVotes = votes.get(answerId);
        if (answerVotes == null)
            return Collections.emptyList();
        return answerVotes.stream().filter(vote -> vote.author(visitorId)).collect(Collectors.toList());
    }
}
