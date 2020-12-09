package fr.baldir.learn.kata.prime;

import org.junit.jupiter.api.Test;

import java.util.Collections;

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
    @Test void should_generate_the_prime_factors_of_a_given_number(){
        // Programming by wishful thinking
        // Ce que j'aimerais voir comme API
        // On se laisse guider par le compilateur et l'ide
//        assertThat(new PrimeFactors(3).generate())
//                .isEqualTo(Collections.singletonList(3));
//
        // Au lieu de 3 on pirrait tester 1. emptyList
        // C'est un degenerate case (cas subtil)
        // Le cas le plus simple
        assertThat(new PrimeFactors().generate(1))
                .isEqualTo(Collections.emptyList());

        // Quel va être le 2eme test?
        // On veut faire un nouveau test rouge qui ajoute une fonctionalité
        assertThat(new PrimeFactors().generate(2))
                .isEqualTo(Collections.singletonList(2));
        // Le but c'est d'aller le plus vite possible (ca peut etre crade




    }
}