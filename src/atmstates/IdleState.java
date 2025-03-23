package atmstates;

import models.ATM;
import models.Card;

public class IdleState extends ATMState {

    private final ATM atm;
    private Card card;

    public IdleState(ATM atm) {
        this.atm = atm;
        this.card = null;
    }

    @Override
    public void insertCard(Card card) {
        this.card = card;
        this.atm.setAtmState(new AuthenticationState(this.atm, this.card));
    }
}
