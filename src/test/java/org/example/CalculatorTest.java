package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Tests de la classe Calculator")
public class CalculatorTest {

    private com.example.Calculator calculator;

    @BeforeAll
    public static void initAll() {
        System.out.println("=== DÉBUT DE LA CAMPAGNE DE TESTS ===");
    }

    @BeforeEach
    public void setUp() {
        calculator = new com.example.Calculator();
        System.out.println("→ Initialisation du Calculator pour un nouveau test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("✓ Test terminé\n");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("=== FIN DE LA CAMPAGNE DE TESTS ===");
    }

    // ========================================
    // TESTS DE LA MÉTHODE ADD
    // ========================================

    @Test
    @DisplayName("add() - Addition de deux nombres positifs")
    public void add_returnsSum_whenAddingPositiveNumbers() {
        // Given
        int a = 2;
        int b = 3;

        // When
        int result = calculator.add(a, b);

        // Then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("add() - Addition d'un nombre négatif et d'un nombre positif")
    public void add_returnsSum_whenAddingNegativeAndPositive() {
        // Given
        int a = -2;
        int b = 5;

        // When
        int result = calculator.add(a, b);

        // Then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("add() - Addition avec zéro")
    public void add_returnsOriginalNumber_whenAddingZero() {
        // Given
        int a = 10;
        int b = 0;

        // When
        int result = calculator.add(a, b);

        // Then
        assertEquals(10, result);
    }

    // ========================================
    // TESTS DE LA MÉTHODE SUBTRACT
    // ========================================

    @Test
    @DisplayName("subtract() - Soustraction normale")
    public void subtract_returnsDifference_whenSubtractingPositiveNumbers() {
        // Given
        int a = 8;
        int b = 5;

        // When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("subtract() - Soustraction avec résultat négatif")
    public void subtract_returnsNegative_whenSecondNumberIsLarger() {
        // Given
        int a = 3;
        int b = 5;

        // When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(-2, result);
    }

    @Test
    @DisplayName("subtract() - Soustraction de nombres identiques")
    public void subtract_returnsZero_whenSubtractingSameNumbers() {
        // Given
        int a = 10;
        int b = 10;

        // When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(0, result);
    }

    // ========================================
    // TESTS DE LA MÉTHODE MULTIPLY
    // ========================================

    @Test
    @DisplayName("multiply() - Multiplication normale")
    public void multiply_returnsProduct_whenMultiplyingPositiveNumbers() {
        // Given
        int a = 2;
        int b = 3;

        // When
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("multiply() - Multiplication avec un nombre négatif")
    public void multiply_returnsNegativeProduct_whenOneNumberIsNegative() {
        // Given
        int a = -3;
        int b = 5;

        // When
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(-15, result);
    }

    @Test
    @DisplayName("multiply() - Multiplication par zéro")
    public void multiply_returnsZero_whenMultiplyingByZero() {
        // Given
        int a = 7;
        int b = 0;

        // When
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(0, result);
    }

    // ========================================
    // TESTS DE LA MÉTHODE DIVIDE
    // ========================================

    @Test
    @DisplayName("divide() - Division normale")
    public void divide_returnsQuotient_whenDividingNumbers() {
        // Given
        int a = 10;
        int b = 2;

        // When
        int result = calculator.divide(a, b);

        // Then
        assertEquals(5, result);
    }

    @Test
    @DisplayName("divide() - Division par zéro lance une exception")
    public void shouldThrowArithmeticException_whenDividingByZero() {
        // Given
        int a = 10;
        int b = 0;

        // When & Then
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a, b);
        });
    }

    @Test
    @DisplayName("divide() - Division avec résultat négatif")
    public void divide_returnsNegativeQuotient_whenDividingNegativeByPositive() {
        // Given
        int a = -6;
        int b = 3;

        // When
        int result = calculator.divide(a, b);

        // Then
        assertEquals(-2, result);
    }

    // ========================================
    // TESTS DE LA MÉTHODE POWER
    // ========================================

    @Test
    @DisplayName("power() - Puissance normale")
    public void power_returnsCorrectResult_whenCalculatingPower() {
        // Given
        int base = 2;
        int exponent = 3;

        // When
        int result = calculator.power(base, exponent);

        // Then
        assertEquals(8, result);
    }

    @Test
    @DisplayName("power() - Puissance avec exposant zéro")
    public void power_returnsOne_whenExponentIsZero() {
        // Given
        int base = 5;
        int exponent = 0;

        // When
        int result = calculator.power(base, exponent);

        // Then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("power() - Puissance avec base négative")
    public void power_returnsPositive_whenNegativeBaseWithEvenExponent() {
        // Given
        int base = -3;
        int exponent = 2;

        // When
        int result = calculator.power(base, exponent);

        // Then
        assertEquals(9, result);
    }

    @Test
    @DisplayName("power() - Puissance avec exposant 1")
    public void power_returnsBase_whenExponentIsOne() {
        // Given
        int base = 7;
        int exponent = 1;

        // When
        int result = calculator.power(base, exponent);

        // Then
        assertEquals(7, result);
    }
}