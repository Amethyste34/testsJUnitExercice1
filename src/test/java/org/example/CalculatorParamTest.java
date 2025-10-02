package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Tests paramétrés de la classe Calculator")
public class CalculatorParamTest {

    private org.example.Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new org.example.Calculator();
    }

    // ========================================
    // TESTS PARAMÉTRÉS AVEC @ValueSource
    // ========================================

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("multiply() - Multiplication par 2 retourne toujours un nombre pair")
    public void shouldReturnEvenResult_whenMultiplyingByTwo(int number) {
        // Given & When
        int result = calculator.multiply(number, 2);

        // Then
        assertEquals(0, result % 2, "Le résultat devrait être pair");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("multiply() - Multiplication d'un nombre impair par un nombre pair")
    public void shouldReturnEvenResult_whenMultiplyingOddByEven(int oddNumber) {
        // Given & When
        int result = calculator.multiply(oddNumber, 4);

        // Then
        assertEquals(0, result % 2, "Le résultat devrait être pair");
    }

    // ========================================
    // TESTS PARAMÉTRÉS AVEC @CsvSource
    // ========================================

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "10, 4, 6",
            "7, 7, 0",
            "0, 5, -5",
            "15, 10, 5"
    })
    @DisplayName("subtract() - Soustraction avec différentes combinaisons")
    public void shouldReturnExpectedResult_whenSubtracting(int a, int b, int expected) {
        // Given & When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "10, 2, 5",
            "20, 4, 5",
            "100, 10, 10",
            "-15, 3, -5"
    })
    @DisplayName("divide() - Division avec différentes combinaisons")
    public void shouldReturnExpectedQuotient_whenDividing(int a, int b, int expected) {
        // Given & When
        int result = calculator.divide(a, b);

        // Then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 8",
            "3, 2, 9",
            "5, 0, 1",
            "10, 1, 10",
            "4, 3, 64"
    })
    @DisplayName("power() - Puissance avec différentes combinaisons")
    public void shouldReturnExpectedPower_whenCalculatingPower(int base, int exponent, int expected) {
        // Given & When
        int result = calculator.power(base, exponent);

        // Then
        assertEquals(expected, result);
    }
}