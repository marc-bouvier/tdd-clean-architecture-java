package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Vote;

import java.util.List;

/**
 * A repository should only allow to manipulate an aggreegate by its root.
 * An aggregate is all the entities that are Cohesive together in the context of a transaction.
 */
public interface VoteRepository {


    List<Vote> byIds(String answerId, String visitorId);

    void save(Vote vote);

    boolean hasNeverVotedYet(String answerId, String visitorId);
}