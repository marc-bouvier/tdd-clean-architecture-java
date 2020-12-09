package com.stackweal.hexagone.models;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
public class Vote {
    private int value;
    private final String answerId;

    public Vote(@NonNull String answerId, int value) {
        this.answerId = answerId;
        this.value = value;
    }

    public void increment() {
        this.value += 1;
    }
}
