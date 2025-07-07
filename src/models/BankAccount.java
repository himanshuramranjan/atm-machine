package models;

import enums.AccountType;

public class BankAccount {
    private final String accountId;
    private final AccountType accountType;
    private double balance;

    public BankAccount(String accountId, AccountType accountType, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void creditMoney(double amount) {
        this.balance += amount;
    }

    public void deductAmount(double amount) {
        this.balance -= amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
