package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Vote;

public interface VoteRepository {
    Vote byAnswerId(String answerId) ;

//    void save(String answerId, Vote vote);
}
