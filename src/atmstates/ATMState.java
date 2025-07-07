package atmstates;

import enums.TransactionType;
import models.BankAccount;
import models.Card;
import service.withdrawal_processor.CashWithdrawalProcessor;

public interface ATMState {
    void insertCard(Card card);
    void authenticateCard(int pin);
    void selectOperations(TransactionType transactionType, BankAccount bankAccount);
    void cashWithdrawal(CashWithdrawalProcessor cashWithdrawalProcessor, int amount);
    void exitTransaction();
    void displayBalance();
}
