package withdrawal_processor;

import enums.DenominationType;
import service.ATM;

import java.util.Map;

public class TwoThousandCashWithdrawalProcessor extends CashWithdrawalProcessor {

    public TwoThousandCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdrawCash(ATM atm, int amount) {
        Map<DenominationType, Integer> availableDenominations = atm.getDenominations();
        int twoThousandDenomination = availableDenominations.get(DenominationType.TWO_THOUSAND);
        int requiredDenominations = amount / DenominationType.TWO_THOUSAND.getValue();
        int remAmount = requiredDenominations % DenominationType.TWO_THOUSAND.getValue();

        if(requiredDenominations >= twoThousandDenomination) {
            availableDenominations.put(DenominationType.TWO_THOUSAND, 0);
        } else {
            availableDenominations.put(DenominationType.TWO_THOUSAND, availableDenominations.get(DenominationType.TWO_THOUSAND) - requiredDenominations);
        }

        if(remAmount != 0) {
            super.withdrawCash(atm, remAmount);
        }
    }

}
