package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Card {

    private final String cardNumber;
    private final int cvv;
    private final LocalDate expiryDate;

    private final BankAccount bankAccount;
    private int pinNumber;

    public Card(BankAccount bankAccount, String cardNumber, int cvv, LocalDate expiryDate, int pinNumber) {
        this.bankAccount = bankAccount;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.pinNumber = pinNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void updatePin(int oldPin, int newPin) throws Exception {
        if(validatePin(oldPin)) {
            this.pinNumber = newPin;
        }
        else {
            throw new Exception("Pin number is not matching");
        }
    }

    public boolean validatePin(int pin) {
        return pin == this.pinNumber;
    }
}
