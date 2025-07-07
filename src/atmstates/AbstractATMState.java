package atmstates;

import enums.TransactionType;
import models.BankAccount;
import models.Card;
import service.ATM;
import service.withdrawal_processor.CashWithdrawalProcessor;

public class AbstractATMState implements ATMState {

    protected final ATM atm;

    protected AbstractATMState(ATM atm) { this.atm = atm; }
    @Override
    public void insertCard(Card card) {
        invalidateOperation();
    }

    @Override
    public void authenticateCard(int pin) {
        invalidateOperation();
    }

    @Override
    public void selectOperations(TransactionType transactionType, BankAccount bankAccount) {
        invalidateOperation();
    }

    @Override
    public void cashWithdrawal(CashWithdrawalProcessor cashWithdrawalProcessor, int amount) {
        invalidateOperation();
    }

    @Override
    public void exitTransaction() {
        invalidateOperation();
    }

    @Override
    public void displayBalance() {
        invalidateOperation();
    }

    protected void invalidateOperation() {
        System.out.println("Invalid operation, something went wrong");
    }
}
