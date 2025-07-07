package atmstates;

import service.ATM;

public class AuthenticationState extends AbstractATMState {

    public AuthenticationState(ATM atm) {
        super(atm);
    }

    @Override
    public void authenticateCard(int pin) {
        boolean isAuthenticated = atm.getTransactionContext().getCard().validatePin(pin);
        atm.getTransactionContext().setAuthenticated(isAuthenticated);

        if(isAuthenticated) {
            System.out.println("Card is authenticated, select your transaction and Bank Account");
            atm.setAtmState(new SelectOperationState(atm));
        } else {
            System.out.println("Incorrect pin, try again");
        }
    }

    @Override
    public void exitTransaction() {
        atm.resetTransactionContext();
        atm.setAtmState(new IdleState(atm));
    }
}
