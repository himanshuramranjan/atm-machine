package models;

public class User {

    private String name;
    private BankAccount bankAccount;
    private Card card;

    public User(String name, BankAccount bankAccount, Card card) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
