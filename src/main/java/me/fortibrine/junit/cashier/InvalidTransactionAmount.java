package me.fortibrine.junit.cashier;

public class InvalidTransactionAmount extends RuntimeException {

    public InvalidTransactionAmount(String message) {
        super(message);
    }

}
