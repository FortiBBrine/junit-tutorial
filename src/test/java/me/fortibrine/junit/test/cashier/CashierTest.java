package me.fortibrine.junit.test.cashier;

import me.fortibrine.junit.cashier.Cashier;
import me.fortibrine.junit.cashier.InvalidTransactionAmount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashierTest {

    @Test
    public void validateTransactionThrowIllegalArgument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Cashier.validateTransaction("USD", 10)
        );
    }

    @Test
    public void validateTransactionAmountNegative() {
        assertThrows(
                InvalidTransactionAmount.class,
                () -> Cashier.validateTransaction("EUR", -10)
        );
    }

}
