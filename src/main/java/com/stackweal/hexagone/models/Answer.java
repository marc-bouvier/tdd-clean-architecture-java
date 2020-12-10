package com.stackweal.hexagone.models;

public class Answer {
    private final String answerId;

    public Answer(String answerId) {
        this.answerId = answerId;
    }

    public boolean hasId(String answerId) {
        return this.answerId.equals(answerId);
    }
}
