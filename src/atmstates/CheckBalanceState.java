package atmstates;

import service.ATM;

public class CheckBalanceState extends AbstractATMState {

    public CheckBalanceState(ATM atm) {
        super(atm);
    }

    @Override
    public void displayBalance() {
        double balance = atm.getTransactionContext().getSelectedBankAccount().getBalance();
        System.out.println("Your bank balance is : " + balance);
        atm.resetTransactionContext();
        atm.setAtmState(new IdleState(this.atm));
    }
}
