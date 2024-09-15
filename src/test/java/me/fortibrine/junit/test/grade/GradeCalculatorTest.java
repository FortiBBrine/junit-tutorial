package me.fortibrine.junit.test.grade;

import me.fortibrine.junit.grade.GradeCalculator;
import org.junit.jupiter.api.Test;
//import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculatorTest {

    @Test
    public void computeGradeWithReflections() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GradeCalculator calculator = new GradeCalculator();

        Method computeGrade = calculator.getClass()
                .getDeclaredMethod("computeGrade", int.class);

        computeGrade.setAccessible(true);

        String actualGrade = (String) computeGrade.invoke(calculator, 70);
        String expectedGrade = "Pass";

        assertEquals(expectedGrade, actualGrade);
    }

//    @Test
//    public void computeGradeWithPowermock() throws Exception {
//        GradeCalculator calculator = new GradeCalculator();
//        String actualGrade = Whitebox.invokeMethod(calculator, "computeGrade", 70);
//        String expectedGrade = "Pass";
//
//        assertEquals(expectedGrade, actualGrade);
//    }

}
