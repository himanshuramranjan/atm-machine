package atmstates;

import enums.TransactionType;
import models.BankAccount;
import service.ATM;

public class SelectOperationState extends AbstractATMState {
    public SelectOperationState(ATM atm) {
        super(atm);
    }
    @Override
    public void selectOperations(TransactionType transactionType, BankAccount bankAccount) {
        atm.getTransactionContext().setTransactionType(transactionType);
        atm.getTransactionContext().setSelectedBankAccount(bankAccount);

        switch (transactionType) {
            case WITHDRAW_MONEY :
                atm.setAtmState(new CashWithdrawalState(atm));
                break;
            case BALANCE_CHECK :
                atm.setAtmState(new CheckBalanceState(atm));
                break;
        }
    }
}
