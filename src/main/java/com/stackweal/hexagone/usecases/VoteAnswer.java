package com.stackweal.hexagone.usecases;

import com.stackweal.hexagone.gateways.AnswerRepository;
import com.stackweal.hexagone.gateways.TransactionPerformer;
import com.stackweal.hexagone.gateways.VoteRepository;
import com.stackweal.hexagone.models.Vote;

/**
 * An use case is the entry point of the domain.
 * It should not depend on frameworks. Only rely on domain classes and ports.
 */
public class VoteAnswer {

    private final VoteRepository voteRepository;
    private final AnswerRepository answerRepository;
    private final TransactionPerformer transactionPerformer;

    public VoteAnswer(VoteRepository voteRepository,
                      AnswerRepository answerRepository,
                      TransactionPerformer transactionPerformer) {
        this.voteRepository = voteRepository;
        this.answerRepository = answerRepository;
        this.transactionPerformer = transactionPerformer;
    }

    public void handle(String visitorId, String answerId) {
        // Transaction should be handled inside the use case because anythinfg couyld happen after a transaction
        // sensitive operation
        transactionPerformer.execute(() -> {
            boolean answerExists = answerRepository.exists(answerId);
            if (!answerExists)
                return;
            boolean hasNeverVotedYet = voteRepository.hasNeverVotedYet(answerId, visitorId);
            if (hasNeverVotedYet)
                voteRepository.save(new Vote(answerId, visitorId));
        });
    }
}
