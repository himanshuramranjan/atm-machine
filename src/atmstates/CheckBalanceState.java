package atmstates;

import models.ATM;
import models.Card;

public class CheckBalanceState extends ATMState {
    private final ATM atm;
    private final Card card;

    public CheckBalanceState(ATM atm, Card card) {
        this.atm = atm;
        this.card = card;
    }

    @Override
    public void displayBalance() {
        double balance = this.card.getBankAccount().getBalance();
        System.out.println("Your bank balance is : " + balance);
        this.atm.setAtmState(new IdleState(this.atm));
    }
}
