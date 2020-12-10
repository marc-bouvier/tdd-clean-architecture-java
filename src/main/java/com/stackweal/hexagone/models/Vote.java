package com.stackweal.hexagone.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Domain model is agnostic from persitance ORM. It should not have JPA or hibernate annotations.
 * It should be able to check its invariants.
 */
@EqualsAndHashCode
@ToString
public class Vote {

    private String answerId;
    private int value;

    public Vote(String answerId, int value) {
        this.answerId = answerId;
        this.value = value;
    }

    public void increment() {
        this.value += 1;
    }
}