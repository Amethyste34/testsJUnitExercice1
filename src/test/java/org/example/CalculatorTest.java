package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {

    private com.example.Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new com.example.Calculator();
    }

    // ========== PARTIE GUIDÉE ==========

    // Tests pour add()
    @Test
    public void testAddPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testAddNegativeAndPositive() {
        assertEquals(3, calculator.add(-2, 5));
    }

    // Tests pour divide()
    @Test
    public void testDivideNormal() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    // ========== PARTIE AUTONOME ==========

    // Tests pour multiply()
    @Test
    public void testMultiplyNormalCase() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testMultiplyWithNegative() {
        assertEquals(-15, calculator.multiply(-3, 5));
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0, calculator.multiply(7, 0));
    }

    // Tests pour subtract()
    @Test
    public void testSubtractNormalCase() {
        assertEquals(3, calculator.subtract(8, 5));
    }

    @Test
    public void testSubtractWithNegativeResult() {
        assertEquals(-2, calculator.subtract(3, 5));
    }

    @Test
    public void testSubtractSameNumbers() {
        assertEquals(0, calculator.subtract(10, 10));
    }

    // Tests pour power()
    @Test
    public void testPowerNormalCase() {
        assertEquals(8, calculator.power(2, 3));
    }

    @Test
    public void testPowerWithZeroExponent() {
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    public void testPowerWithNegativeBase() {
        assertEquals(9, calculator.power(-3, 2));
    }

    @Test
    public void testPowerWithOne() {
        assertEquals(7, calculator.power(7, 1));
    }
}