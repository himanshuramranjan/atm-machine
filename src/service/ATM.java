package service;

import atmstates.ATMState;
import atmstates.IdleState;
import models.TransactionContext;

public class ATM {

    private ATMState atmState;
    private TransactionContext transactionContext;
    private final CashManager cashManager;

    private ATM() {
        this.atmState = new IdleState(this);
        this.cashManager = CashManager.getInstance();
        transactionContext = new TransactionContext();
    }
    private static class ATMHelper {
        private static final ATM INSTANCE = new ATM();
    }

    public static ATM getInstance() {
        return ATMHelper.INSTANCE;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public TransactionContext getTransactionContext() {
        return transactionContext;
    }

    public void resetTransactionContext() {
        this.transactionContext = new TransactionContext();
    }

    public CashManager getCashManager() {
        return cashManager;
    }
}
