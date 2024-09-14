package me.fortibrine.junit.cashier;

import java.util.Arrays;
import java.util.List;

public class Cashier {

    private static final List<String> acceptedCurrencies = Arrays.asList("EUR", "GBP");

    public static double validateTransaction(String currency, double amount) {
        if (currencyIsAccepted(currency) && amountIsValid(amount)) {
            return amount;
        }
        return -1;
    }

    private static boolean currencyIsAccepted(String currency) {
        if (!acceptedCurrencies.contains(currency)) {
            throw new IllegalArgumentException("Unknown currency: " + currency);
        }

        return true;
    }

    private static boolean amountIsValid(double amount) {
        if (amount < 0) {
            throw new InvalidTransactionAmount("Negative amount: " + amount);
        }

        return true;
    }

}
