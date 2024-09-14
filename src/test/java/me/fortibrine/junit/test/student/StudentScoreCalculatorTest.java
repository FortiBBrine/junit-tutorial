package me.fortibrine.junit.test.student;

import me.fortibrine.junit.student.StudentScoreCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentScoreCalculatorTest {

    static Object[] testValues() {
        return new Object[]{
                new Object[]{50, 50, 2500},
                new Object[]{-10, 50, -1},
                new Object[]{50, -1, -1},
                new Object[]{-1, -1, -1},
                new Object[]{150, 50, -1},
                new Object[]{50, 150, -1},
                new Object[]{150, 150, -1},
                new Object[]{0, 0, 0},
                new Object[]{100, 100, 10_000}
        };
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void studentScoreCalculator(int mathsScore, int literacyScore, int expectedScore) {
        StudentScoreCalculator calculator = new StudentScoreCalculator();
        calculator.calculateSATScore(mathsScore, literacyScore);
        assertEquals(expectedScore, calculator.getSatScore());
    }

}
