package fr.baldir.learn.kata.prime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

public class PrimeFactorsTest {

    // On sait pas par quel bout le prendre
    // On se bloque

    // IL évite les détails du quoi et des résultats dans les libellés de tests
    // Ex. on donne un titre générique au premier test
    @Test
    void should_generate_the_prime_factors_of_a_given_number() {

        assertGeneratedPrimeFactors(1); // constante
        assertGeneratedPrimeFactors(2, 2);
        assertGeneratedPrimeFactors(3, 3); // varaible
        assertGeneratedPrimeFactors(4, 2, 2); // condition
        assertGeneratedPrimeFactors(6, 2, 3); // coup de bol ca passe avec le 6




    }

    private List<Integer> generateFor(int i) {
        return new PrimeFactors().generate(i);
    }

    private void assertGeneratedPrimeFactors(int n, Integer... expectedPrimeFactors) {
        assertThat(generateFor(n))
                .isEqualTo(Arrays.asList(expectedPrimeFactors));
    }
}