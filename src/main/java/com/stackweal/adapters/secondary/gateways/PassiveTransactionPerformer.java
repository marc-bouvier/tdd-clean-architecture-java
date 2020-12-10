package com.stackweal.adapters.secondary.gateways;

import com.stackweal.hexagone.gateways.TransactionPerformer;

/**
 * This transaction performer as a neutral implementation without transaction handling
 * @apiNote not production code.
 */
public class PassiveTransactionPerformer implements TransactionPerformer {

    @Override
    public void execute(Runnable useCaseCode) {
        useCaseCode.run();
    }
}
