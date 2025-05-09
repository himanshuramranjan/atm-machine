package models;

import atmstates.ATMState;
import atmstates.IdleState;
import enums.DenominationType;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    public static volatile ATM atm;
    private ATMState atmState;
    private final Map<DenominationType, Integer> denominations;
    private int amount;

    private ATM(Map<DenominationType, Integer> denominations) {
        this.atmState = new IdleState(this);
        this.denominations = new HashMap<>();
        addMoney(denominations);
    }

    public static ATM getInstance(Map<DenominationType, Integer> denominations) {
        if(atm == null) {
            synchronized (ATM.class) {
                if(atm == null) {
                    atm = new ATM(denominations);
                }
            }
        }
        return atm;
    }

    public void addMoney(Map<DenominationType, Integer> currencies) {
        for(DenominationType currency : currencies.keySet()) {
            this.denominations.put(currency, this.denominations.getOrDefault(currency, 0) + currencies.get(currency));
            this.amount += (denominations.get(currency) * currency.getValue());
        }
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public int getAmount() {
        return amount;
    }

    public Map<DenominationType, Integer> getDenominations() {
        return denominations;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }
}
