package atmstates;

import models.ATM;
import models.Card;
import withdrawal_processor.CashWithdrawalProcessor;
import withdrawal_processor.FiveHundredCashWithdrawalProcessor;
import withdrawal_processor.HundredCashWithdrawalProcessor;
import withdrawal_processor.TwoThousandCashWithdrawalProcessor;

public class CashWithdrawalState extends ATMState {
    private final ATM atm;

    private final Card card;

    public CashWithdrawalState(ATM atm, Card card) {
        this.atm = atm;
        this.card = card;
    }

    @Override
    public void cashWithdrawal(int amount) {
        boolean isTransactionSuccessful = this.card.getBankAccount().deductAmount(amount);
        boolean hasAtmMoney = this.atm.getAmount() >= amount;

        if(!(isTransactionSuccessful && hasAtmMoney)) {
            System.out.println("Insufficient Account balance or Unable to dispense money");
        } else {
            CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandCashWithdrawalProcessor(new FiveHundredCashWithdrawalProcessor(new HundredCashWithdrawalProcessor(null)));
            cashWithdrawalProcessor.withdrawCash(this.atm, amount);
            System.out.println("Please collect your cash !!!");
        }
        exitTransaction();
    }

    @Override
    public void exitTransaction() {
        this.atm.setAtmState(new IdleState(this.atm));
    }

}
