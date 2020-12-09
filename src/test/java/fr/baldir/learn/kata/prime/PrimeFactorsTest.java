package fr.baldir.learn.kata.prime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

// Donner tous les facteurs premiers d'un nombre dans
// l'ordre croissant et retournant comme résultat
// une liste donc ordonnée de ces nombres
// 3 => 3
// 6 => 2 3 => 2 * 3
// 8 => 2 2 2
//
// Ex. qui sert de test d'acceptation
// 78972378232 => 2, 2, 2, 11, 31, 1597, 18127

class PrimeFactorsTest {

    // On sait pas par quel bout le prendre
    // On se bloque

    // IL évite les détails du quoi et des résultats dans les libellés de tests
    // Ex. on donne un titre générique au premier test
    @Test
    void should_generate_the_prime_factors_of_a_given_number() {

        assertGeneratedPrimeFactors(1); // constante
        assertGeneratedPrimeFactors(2, 2);
        assertGeneratedPrimeFactors(3, 3); // varaible
        assertGeneratedPrimeFactors(4, 2, 2); // condition, statement,
        assertGeneratedPrimeFactors(8, 2, 2,2);  // boucle
                assertGeneratedPrimeFactors(9, 3,3);  // boucle
        assertGeneratedPrimeFactors(78972378232L ,2, 2, 2, 11, 31, 1597, 18127);



    }

    private List<Long> generateFor(long n) {
        return new PrimeFactors().generate(n);
    }

    private void assertGeneratedPrimeFactors(long n, Integer... expectedPrimeFactors) {
        assertThat(generateFor(n))
                .isEqualTo(Arrays.stream(expectedPrimeFactors)
                        .map(Integer::longValue).collect(Collectors.toList()));

    }
}