package withdrawal_processor;

import service.ATM;

public class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdrawCash(ATM atm, int amount) {
        if(nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdrawCash(atm, amount);
        }
    }
}
