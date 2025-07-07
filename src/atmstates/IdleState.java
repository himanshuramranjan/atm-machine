package atmstates;

import service.ATM;
import models.Card;

public class IdleState extends AbstractATMState {
    public IdleState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        atm.getTransactionContext().setCard(card);
        atm.setAtmState(new AuthenticationState(atm));
    }
}
