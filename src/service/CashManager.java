package service;

import enums.DenominationType;

import java.util.*;

public class CashManager {

    private final Map<DenominationType, Integer> cashBox;
    private float totalAmount;
    public static volatile CashManager cashManager;

    private CashManager() {
        cashBox = new HashMap<>();
        totalAmount = 0;
    }

    public static CashManager getInstance() {
        if(cashManager == null) {
            synchronized (CashManager.class) {
                if(cashManager == null) {
                    cashManager = new CashManager();
                }
            }
        }
        return cashManager;
    }

    public void addNotes(Map<DenominationType, Integer> insertedNotes) {
        for (DenominationType note : insertedNotes.keySet()) {
            cashBox.put(note, cashBox.getOrDefault(note, 0) + insertedNotes.get(note));
        }
    }

    public boolean hasSufficientChange(int amount) {
        List<DenominationType> denominations = new ArrayList<>(cashBox.keySet());
        denominations.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (DenominationType note : denominations) {
            int available = cashBox.getOrDefault(note, 0);
            int count = Math.min(available, amount / note.getValue());
            amount -= count * note.getValue();
        }

        return amount == 0;
    }

    public float getTotalAmount() {
        for (DenominationType note : cashBox.keySet()) {
            totalAmount += cashBox.get(note) * note.getValue();
        }
        return totalAmount;
    }

    public void deductCash(DenominationType type, int count) {
        int existing = cashBox.get(type);
        cashBox.put(type, existing - count);
    }

    public Map<DenominationType, Integer> getCashBox() {
        return Collections.unmodifiableMap(cashBox);
    }
}
