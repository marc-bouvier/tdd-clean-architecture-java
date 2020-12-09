package com.stackweal.hexagone.models;

import java.util.Objects;

public class Vote {
    private  int i;
    private String answerId;

    public Vote(String answerId,int i) {

        this.i = i;
    }

    public void increment() {
       this.i=1;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return i == vote.i &&
                Objects.equals(answerId, vote.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, answerId);
    }
}
