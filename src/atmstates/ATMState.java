package atmstates;

import enums.TransactionType;
import models.ATM;
import models.Card;

public class ATMState {
    public void insertCard(Card card) {
        System.out.println("Invalid operation, something went wrong");
    }

    public void authenticateCard(int pin) {
        System.out.println("Invalid operation, something went wrong");
    }

    public void selectOperations(TransactionType transactionType) {
        System.out.println("Invalid operation, something went wrong");
    }

    public void cashWithdrawal(int amount) {
        System.out.println("Invalid operation, something went wrong");
    }

    public void displayBalance() {
        System.out.println("Invalid operation, something went wrong");
    }

    public void exitTransaction() {
        System.out.println("Invalid operation, something went wrong");
    }
}
