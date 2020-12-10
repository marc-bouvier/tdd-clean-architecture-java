package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Vote;

/**
 * A repository should only allow to manipulate an aggreegate by its root.
 * An aggregate is all the entities that are Cohesive together in the context of a transaction.
 */
public interface VoteRepository {

    Vote byAnswerId(String answerId);

}