package com.mockitoCourse.gradeCalculator;

import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    public void computeGradeWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        GradeCalculator gc = new GradeCalculator();

        //Creates a array of classes
        //Chosing the method that i want to use
        //Set the private method acessible for the test use
        Class[] parameters = new Class[1];
        parameters[0] = Integer.class;
        Method methodCall = gc.getClass()
                .getDeclaredMethod("computeGrade", parameters);
        methodCall.setAccessible(true);

        Object[] methodArgument = new Object[1];
        methodArgument[0] = 70;

        String actualGrade = (String) methodCall.invoke(gc, methodArgument);
        String expectedGrade = "Pass";

        assertEquals(expectedGrade, actualGrade);
    }

    @Test
    public void computeGradeWithPowerMock() throws Exception {

        GradeCalculator gc = new GradeCalculator();
        String actualGrade = Whitebox.invokeMethod(gc,"computeGrade", 70);
        String expectedGrade = "Pass";

        assertEquals(expectedGrade, actualGrade);
    }

}