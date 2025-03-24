package withdrawal_processor;

import enums.DenominationType;
import models.ATM;

import java.util.Map;

public class FiveHundredCashWithdrawalProcessor extends CashWithdrawalProcessor {
    public FiveHundredCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdrawCash(ATM atm, int amount) {
        Map<DenominationType, Integer> availableDenominations = atm.getDenominations();
        int twoThousandDenomination = availableDenominations.get(DenominationType.FIVE_HUNDRED);
        int requiredDenominations = amount / DenominationType.FIVE_HUNDRED.getValue();
        int remAmount = requiredDenominations % DenominationType.FIVE_HUNDRED.getValue();

        if(requiredDenominations >= twoThousandDenomination) {
            availableDenominations.put(DenominationType.FIVE_HUNDRED, 0);
        } else {
            availableDenominations.put(DenominationType.FIVE_HUNDRED, availableDenominations.get(DenominationType.FIVE_HUNDRED) - requiredDenominations);
        }

        if(remAmount != 0) {
            super.withdrawCash(atm, remAmount);
        }
    }
}
