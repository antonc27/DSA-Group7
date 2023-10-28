package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);

        assertEquals(7, result);
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        int result = calc.subtract(3, 4);

        assertEquals(-1, result);
    }

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);

        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        int result = calc.divide(8, 4);

        assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBy0() {
        Calculator calc = new Calculator();
        int result = calc.divide(8, 0);
    }
}