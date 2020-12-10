package com.stackweal.hexagone.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Domain model is agnostic from persitance ORM. It should not have JPA or hibernate annotations.
 * It should be able to check its invariants.
 */
@EqualsAndHashCode
@ToString
public class Vote {
    @Getter
    private String answerId;
    @Getter
    private String visitorId;


    public Vote(String answerId, String visitorId) {
        this.answerId = answerId;
        this.visitorId = visitorId;
    }


    public boolean author(String visitorId) {
        return this.visitorId.equals(visitorId);
    }
}