package models;

import enums.TransactionType;

public class TransactionContext {
    private BankAccount selectedBankAccount;
    private Card card;
    private float requestedAmount;
    private TransactionType transactionType;
    private boolean isAuthenticated;

    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }

    public BankAccount getSelectedBankAccount() {
        return selectedBankAccount;
    }

    public void setSelectedBankAccount(BankAccount selectedBankAccount) {
        this.selectedBankAccount = selectedBankAccount;
    }

    public TransactionType getTransactionType() { return transactionType; }
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public float getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(float requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public boolean isAuthenticated() { return isAuthenticated; }
    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

}
