package me.fortibrine.junit.test.calculator;

import me.fortibrine.junit.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void squaredIntegerHappyPath() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.squareInteger(3));
        assertEquals(100, calculator.squareInteger(10));
    }

    @Test
    public void squaredIntegerUpperBoundary() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.squareInteger(Integer.MAX_VALUE));
    }

    @Test
    public void squaredIntegerLowerBoundary() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.squareInteger(Integer.MIN_VALUE));
    }

    @Test
    public void squaredIntegerNull() {
        Calculator calculator = new Calculator();

        assertEquals(0, calculator.squareInteger(null));
    }

    @Test
    public void squaredIntegerNegative() {
        Calculator calculator = new Calculator();
        assertEquals(25, calculator.squareInteger(-5));
    }

}
