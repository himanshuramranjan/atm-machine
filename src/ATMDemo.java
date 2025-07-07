import enums.AccountType;
import enums.DenominationType;
import enums.TransactionType;
import service.ATM;
import models.BankAccount;
import models.Card;
import service.CashManager;
import service.withdrawal_processor.CashWithdrawalProcessor;
import service.withdrawal_processor.FiveHundredCashWithdrawalProcessor;
import service.withdrawal_processor.HundredCashWithdrawalProcessor;
import service.withdrawal_processor.TwoThousandCashWithdrawalProcessor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static enums.DenominationType.*;

public class ATMDemo {
    public static void main(String[] args) {

        System.out.println("Welcome to the ATM !!!");

        BankAccount savingAccount = new BankAccount("A", AccountType.SAVINGS, 2000);
        BankAccount currentAccount = new BankAccount("B", AccountType.CURRENT, 100000);

        Card card = new Card(List.of(savingAccount, currentAccount), "45671243", 123, LocalDate.of(2027, 01, 01), 1234);
        CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandCashWithdrawalProcessor(new FiveHundredCashWithdrawalProcessor(new HundredCashWithdrawalProcessor(null)));

        Map<DenominationType, Integer> denominations = Map.of(TWO_THOUSAND, 1, FIVE_HUNDRED, 2, HUNDRED, 10);
        CashManager.getInstance().addNotes(denominations);

        ATM atm = ATM.getInstance();

        atm.getAtmState().insertCard(card);
        atm.getAtmState().authenticateCard(1234);
        atm.getAtmState().selectOperations(TransactionType.WITHDRAW_MONEY, currentAccount);
        atm.getAtmState().cashWithdrawal(cashWithdrawalProcessor, 3500);

    }
}
