package service.withdrawal_processor;

import service.CashManager;

public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    protected CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdrawCash(CashManager cashManager, int amount) {
        if(nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdrawCash(cashManager, amount);
        }
    }
}
