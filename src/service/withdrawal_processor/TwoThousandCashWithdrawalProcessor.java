package service.withdrawal_processor;

import enums.DenominationType;
import service.CashManager;

import java.util.Map;

public class TwoThousandCashWithdrawalProcessor extends CashWithdrawalProcessor {

    public TwoThousandCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdrawCash(CashManager cashManager, int amount) {
        Map<DenominationType, Integer> availableDenominations = cashManager.getCashBox();

        int twoThousandDenomination = availableDenominations.get(DenominationType.TWO_THOUSAND);
        int requiredDenominations = Math.min(amount / DenominationType.TWO_THOUSAND.getValue(), twoThousandDenomination);
        int remAmount = amount - (requiredDenominations * DenominationType.TWO_THOUSAND.getValue());

        cashManager.deductCash(DenominationType.TWO_THOUSAND, requiredDenominations);
        System.out.println("Dispensing 2000 notes : " + requiredDenominations);

        if(remAmount != 0) {
            super.withdrawCash(cashManager, remAmount);
        }
    }

}
