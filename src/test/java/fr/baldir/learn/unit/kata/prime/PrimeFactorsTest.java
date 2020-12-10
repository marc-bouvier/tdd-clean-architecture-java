package fr.baldir.learn.unit.kata.prime;

import fr.baldir.learn.kata.prime.PrimeFactors;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

// Donner tous les facteurs premiers d'un nombre dans l'ordre
// croissant et retournant comme résultat une liste donc ordonnée de ces nombres
// 3 => 3
// 6 => 2 3  => 2 * 3
// 8 => 2 2 2
//
// Le test suivant peut être considéré comme le test d'acceptation du scénario
//
// 78972378232 => 2, 2, 2, 11, 31, 1597, 18127

class PrimeFactorsTest {

    // On sait pas par quel bout le prendre
    // On se bloque

    // IL évite les détails du quoi et des résultats dans les libellés de tests
    // Ex. on donne un titre générique au premier test

    @Test
    void shouldGenerateThePrimeFactorsOfAGivenNumber() {

        // Given
        // When
        // Then

        assertGeneratedPrimeFactors(1);
        assertGeneratedPrimeFactors(2, 2);
        assertGeneratedPrimeFactors(3, 3);
        assertGeneratedPrimeFactors(4, 2, 2);
        assertGeneratedPrimeFactors(6, 2, 3);
        assertGeneratedPrimeFactors(8, 2, 2, 2);
        assertGeneratedPrimeFactors(9, 3, 3);
        assertGeneratedPrimeFactors(78972378232L, 2, 2, 2, 11, 31, 1597, 18127);
    }

    private List<Long> generateFor(long n) {
        return new PrimeFactors().generate(n);
    }

    private void assertGeneratedPrimeFactors(long n, Integer... expectedPrimeFactors) {
        assertThat(generateFor(n)).isEqualTo(
                Arrays.stream(expectedPrimeFactors).map(Integer::longValue).collect(Collectors.toList())
        );
    }
}