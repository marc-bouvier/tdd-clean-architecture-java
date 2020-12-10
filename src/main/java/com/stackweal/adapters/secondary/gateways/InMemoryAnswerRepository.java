package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.AnswerRepository;
import com.stackweal.hexagone.models.Answer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAnswerRepository implements AnswerRepository {
    private List<Answer> answers = new ArrayList<>();

    @Override
    public void existingAnswers(Answer answer) {
        answers.add(answer);
    }

    @Override
    public boolean exists(String answerId) {
        return answers.stream()
                .anyMatch(answer -> answer.hasId(answerId));
    }
}
