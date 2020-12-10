package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Vote;

import java.util.Optional;

/**
 * A repository should only allow to manipulate an aggreegate by its root.
 * An aggregate is all the entities that are Cohesive together in the context of a transaction.
 */
public interface VoteRepository {


    Optional<Vote> byIds(String visitorId, String answerId);

    void save(Vote vote);
}