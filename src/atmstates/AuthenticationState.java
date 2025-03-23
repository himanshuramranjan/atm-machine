package atmstates;

import models.ATM;
import models.Card;

public class AuthenticationState extends ATMState {
    private final ATM atm;
    private final Card card;

    public AuthenticationState(ATM atm, Card card) {
        this.atm = atm;
        this.card = card;
    }

    @Override
    public void authenticateCard(int pin) {
        if(this.card.validatePin(pin)) {
            this.atm.setAtmState(new SelectOperationState(this.atm, this.card));
        } else {
            exitTransaction();
        }
    }

    @Override
    public void exitTransaction() {
        this.atm.setAtmState(new IdleState(this.atm));
    }
}
