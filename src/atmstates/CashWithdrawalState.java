package atmstates;

import service.ATM;
import service.withdrawal_processor.CashWithdrawalProcessor;

public class CashWithdrawalState extends AbstractATMState {
    public CashWithdrawalState(ATM atm) {
        super(atm);
    }

    @Override
    public void cashWithdrawal(CashWithdrawalProcessor cashWithdrawalProcessor, int amount) {
        boolean insufficientBalance = atm.getTransactionContext().getSelectedBankAccount().getBalance() < amount;
        boolean hasInsufficientAmount = !atm.getCashManager().hasSufficientChange(amount);

        if(insufficientBalance || hasInsufficientAmount) {
            System.out.println("Insufficient Account balance or Unable to dispense money");
            exitTransaction();
            return;
        }

        atm.getTransactionContext().getSelectedBankAccount().deductAmount(amount);
        cashWithdrawalProcessor.withdrawCash(atm.getCashManager(), amount);
        System.out.println("Please collect your cash !!!");

        exitTransaction();
    }

    @Override
    public void exitTransaction() {
        atm.resetTransactionContext();
        atm.setAtmState(new IdleState(atm));
    }

}
