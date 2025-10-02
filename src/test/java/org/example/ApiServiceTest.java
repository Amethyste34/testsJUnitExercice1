package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Tests de la classe ApiService avec Mockito")
public class ApiServiceTest {

    private ApiClient mockClient;
    private ApiService service;

    @BeforeEach
    public void setUp() {
        // Création du mock
        mockClient = mock(ApiClient.class);
        service = new ApiService(mockClient);
    }

    // ========================================
    // TESTS DE fetchUppercasedData()
    // ========================================

    @Test
    @DisplayName("fetchUppercasedData() - Retourne les données en majuscules")
    public void shouldReturnUppercaseData() {
        // Given - Configuration du comportement du mock
        when(mockClient.getData()).thenReturn("hello");

        // When
        String result = service.fetchUppercasedData();

        // Then
        assertEquals("HELLO", result);
        verify(mockClient, times(1)).getData();
    }

    @Test
    @DisplayName("fetchUppercasedData() - Appel multiple vérifié avec verify()")
    public void shouldCallGetDataTwice_whenFetchingDataTwice() {
        // Given
        when(mockClient.getData()).thenReturn("world");

        // When - Appel deux fois
        service.fetchUppercasedData();
        service.fetchUppercasedData();

        // Then - Vérification que getData() a été appelé 2 fois
        verify(mockClient, times(2)).getData();
    }

    @Test
    @DisplayName("fetchUppercasedData() - Gère différentes valeurs")
    public void shouldReturnUppercaseData_withDifferentValues() {
        // Given
        when(mockClient.getData()).thenReturn("mockito test");

        // When
        String result = service.fetchUppercasedData();

        // Then
        assertEquals("MOCKITO TEST", result);
        verify(mockClient).getData(); // équivalent à times(1)
    }

    @Test
    @DisplayName("fetchUppercasedData() - Gère une chaîne vide")
    public void shouldReturnEmptyString_whenDataIsEmpty() {
        // Given
        when(mockClient.getData()).thenReturn("");

        // When
        String result = service.fetchUppercasedData();

        // Then
        assertEquals("", result);
        verify(mockClient, times(1)).getData();
    }

    // ========================================
    // TESTS DE hasData() - CAS AUTONOME
    // ========================================

    @Test
    @DisplayName("hasData() - Retourne true quand getData() retourne une chaîne non nulle")
    public void hasData_returnsTrue_whenDataIsNotNull() {
        // Given
        when(mockClient.getData()).thenReturn("some data");

        // When
        boolean result = service.hasData();

        // Then
        assertTrue(result);
        verify(mockClient, times(1)).getData();
    }

    @Test
    @DisplayName("hasData() - Retourne false quand getData() retourne null")
    public void hasData_returnsFalse_whenDataIsNull() {
        // Given
        when(mockClient.getData()).thenReturn(null);

        // When
        boolean result = service.hasData();

        // Then
        assertFalse(result);
        verify(mockClient, times(1)).getData();
    }

    @Test
    @DisplayName("hasData() - Retourne true pour une chaîne vide")
    public void hasData_returnsTrue_whenDataIsEmptyString() {
        // Given
        when(mockClient.getData()).thenReturn("");

        // When
        boolean result = service.hasData();

        // Then
        assertTrue(result, "Une chaîne vide n'est pas null");
        verify(mockClient, times(1)).getData();
    }

    // ========================================
    // TESTS AVEC verify() AVANCÉS
    // ========================================

    @Test
    @DisplayName("verify() - Aucun appel à getData()")
    public void shouldNotCallGetData_whenServiceNotUsed() {
        // Given - on ne fait rien avec le service

        // When - aucune action

        // Then
        verify(mockClient, never()).getData();
    }

    @Test
    @DisplayName("verify() - Au moins un appel à getData()")
    public void shouldCallGetDataAtLeastOnce() {
        // Given
        when(mockClient.getData()).thenReturn("test");

        // When
        service.hasData();
        service.fetchUppercasedData();

        // Then
        verify(mockClient, atLeastOnce()).getData();
        verify(mockClient, atLeast(2)).getData();
    }

    @Test
    @DisplayName("verify() - Maximum 3 appels à getData()")
    public void shouldCallGetDataAtMostThreeTimes() {
        // Given
        when(mockClient.getData()).thenReturn("test");

        // When
        service.hasData();
        service.fetchUppercasedData();

        // Then
        verify(mockClient, atMost(3)).getData();
    }
}