package withdrawal_processor;

import enums.DenominationType;
import models.ATM;

import java.util.Map;

public class HundredCashWithdrawalProcessor extends CashWithdrawalProcessor {
    public HundredCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public boolean withdrawCash(ATM atm, int amount) {
        Map<DenominationType, Integer> availableDenominations = atm.getDenominations();
        int twoThousandDenomination = availableDenominations.get(DenominationType.HUNDRED);
        int requiredDenominations = amount / DenominationType.HUNDRED.getValue();
        int remAmount = requiredDenominations % DenominationType.HUNDRED.getValue();

        if(requiredDenominations >= twoThousandDenomination) {
            availableDenominations.put(DenominationType.HUNDRED, 0);
        } else {
            availableDenominations.put(DenominationType.HUNDRED, availableDenominations.get(DenominationType.HUNDRED) - requiredDenominations);
        }

        return remAmount == 0;
    }
}
