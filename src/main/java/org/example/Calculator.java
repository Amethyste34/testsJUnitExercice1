package com.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("L'exposant doit être positif");
        }
        return (int) Math.pow(a, b);
    }
}