package atmstates;

import enums.TransactionType;
import models.ATM;
import models.Card;

public class SelectOperationState extends ATMState {
    private final ATM atm;
    private final Card card;

    public SelectOperationState(ATM atm, Card card) {
        this.atm = atm;
        this.card = card;
    }

    @Override
    public void selectOperations(TransactionType transactionType) {
        switch (transactionType) {
            case WITHDRAW_MONEY :
                this.atm.setAtmState(new CashWithdrawalState(this.atm, this.card));
                break;
            case BALANCE_CHECK :
                this.atm.setAtmState(new CheckBalanceState(this.atm, this.card));
                break;
        }
    }
}
