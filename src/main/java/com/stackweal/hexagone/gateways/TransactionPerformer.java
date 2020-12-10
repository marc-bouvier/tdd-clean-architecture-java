package com.stackweal.hexagone.gateways;

/**
 * Allows to explicit the transactions orchestration inside the hexagon.
 * It should be used inside Use case handlers.
 * It can allow to switch transaction mechanisms and avoid transactional annotations from frameworks
 * in the hexagon.
 */
public interface TransactionPerformer {

    void execute(Runnable useCaseCode);

}
