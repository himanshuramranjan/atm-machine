import enums.DenominationType;
import enums.TransactionType;
import models.ATM;
import models.BankAccount;
import models.Card;

import java.time.LocalDate;
import java.util.Map;

import static enums.DenominationType.*;

public class ATMDemo {
    public static void main(String[] args) {

        System.out.println("Welcome to the ATM !!!");

        BankAccount bankAccount = new BankAccount("A", "ABC0123", 2000);
        Card card = new Card(bankAccount, "45671243", 123, LocalDate.of(2027, 01, 01), 1234);
        Map<DenominationType, Integer> denominations = Map.of(TWO_THOUSAND, 4, FIVE_HUNDRED, 5, HUNDRED, 10);

        ATM atm = ATM.getInstance(denominations);

        atm.getAtmState().insertCard(card);
        atm.getAtmState().authenticateCard(1234);
        atm.getAtmState().selectOperations(TransactionType.WITHDRAW_MONEY);
        atm.getAtmState().cashWithdrawal(1200);

    }
}
