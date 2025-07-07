package service.withdrawal_processor;

import enums.DenominationType;
import service.CashManager;

import java.util.Map;

public class HundredCashWithdrawalProcessor extends CashWithdrawalProcessor {
    public HundredCashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdrawCash(CashManager cashManager, int amount) {
        Map<DenominationType, Integer> availableDenominations = cashManager.getCashBox();
        int hundredDenomination = availableDenominations.get(DenominationType.HUNDRED);
        int requiredDenominations = Math.min(amount / DenominationType.HUNDRED.getValue(), hundredDenomination);

        cashManager.deductCash(DenominationType.HUNDRED, requiredDenominations);
        System.out.println("Dispensing 100 notes : " + requiredDenominations);
    }
}
