package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Answer;

public interface AnswerRepository {
    void existingAnswers(Answer answer);

    boolean exists(String answerId);
}
