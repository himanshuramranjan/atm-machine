package atmstates;

import models.ATM;
import models.Card;

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
        if(!isTransactionSuccessful) {
            System.out.println("Insufficient Account balance");
        }
        exitTransaction();
    }

    @Override
    public void exitTransaction() {
        this.atm.setAtmState(new IdleState(this.atm));
    }

}
