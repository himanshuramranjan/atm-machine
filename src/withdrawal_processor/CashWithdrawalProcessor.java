package withdrawal_processor;

import models.ATM;

public class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public boolean withdrawCash(ATM atm, int amount) {
        if(nextCashWithdrawalProcessor != null) {
            return nextCashWithdrawalProcessor.withdrawCash(atm, amount);
        }
        return false;
    }
}
