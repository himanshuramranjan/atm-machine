package service.withdrawal_processor;

import enums.DenominationType;
import service.CashManager;

import java.util.Map;

public class FiveHundredCashWithdrawalProcessor extends CashWithdrawalProcessor {
    public FiveHundredCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdrawCash(CashManager cashManager, int amount) {
        Map<DenominationType, Integer> availableDenominations = cashManager.getCashBox();

        int fiveHundredDenomination = availableDenominations.get(DenominationType.FIVE_HUNDRED);
        int requiredDenominations = Math.min(amount / DenominationType.FIVE_HUNDRED.getValue(), fiveHundredDenomination);
        int remAmount = amount - (requiredDenominations * DenominationType.FIVE_HUNDRED.getValue());

        cashManager.deductCash(DenominationType.FIVE_HUNDRED, requiredDenominations);
        System.out.println("Dispensing 500 notes : " + requiredDenominations);

        if(remAmount != 0) {
            super.withdrawCash(cashManager, remAmount);
        }
    }
}
