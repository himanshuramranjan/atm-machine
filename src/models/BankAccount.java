package models;

public class BankAccount {

    private String customerName;
    private final String accountId;
    private double balance;

    public BankAccount(String name, String accountId, double balance) {
        this.customerName = name;
        this.accountId = accountId;
        this.balance = balance;
    }

    public void creditMoney(double amount) {
        this.balance += amount;
    }

    public boolean deductAmount(double amount) {
        if(amount > balance) return false;
        this.balance -= amount;
        return true;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}
