package com.mockitoCourse.studentScoreCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Not parameterized test */
public class StudentScoreCalculatorTestNotP {

    @Test
    public void studentCalculatorRegular(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(50, 50);
        assertEquals(2500, sc.getSatScore());
    }

    @Test
    public void studentCalculatorMathsNegative(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(-1, 50);
        assertEquals(-1, sc.getSatScore());
    }

    @Test
    public void studentCalculatorLiteracyNegative(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(50, -1);
        assertEquals(-1, sc.getSatScore());
    }

    @Test
    public void studentCalculatorBothNegative(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(-1, -1);
        assertEquals(-1, sc.getSatScore());
    }

    @Test
    public void studentCalculatorMathsHigh(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(150, 50);
        assertEquals(-1, sc.getSatScore());
    }

    @Test
    public void studentCalculatorLiteracyHigh(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(50, 150);
        assertEquals(-1, sc.getSatScore());
    }

    @Test
    public void studentCalculatorBothHigh(){
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(150, 150);
        assertEquals(-1, sc.getSatScore());
    }
}