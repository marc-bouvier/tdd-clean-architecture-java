package com.stackweal.hexagone.models;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
public class Vote {
    private int i;
    private final String answerId;

    public Vote(@NonNull String answerId, int i) {
        this.answerId = answerId;
        this.i = i;
    }

    public void increment() {
        this.i += 1;
    }


}
