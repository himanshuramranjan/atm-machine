package service;

import atmstates.ATMState;
import atmstates.IdleState;
import models.TransactionContext;

public class ATM {

    public static volatile ATM atm;
    private ATMState atmState;
    private TransactionContext transactionContext;
    private final CashManager cashManager;

    private ATM() {
        this.atmState = new IdleState(this);
        this.cashManager = CashManager.getInstance();
        transactionContext = new TransactionContext();
    }

    public static ATM getInstance() {
        if(atm == null) {
            synchronized (ATM.class) {
                if(atm == null) {
                    atm = new ATM();
                }
            }
        }
        return atm;
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
