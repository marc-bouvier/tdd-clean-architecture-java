package fr.baldir.learn.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        // SI ca devient trop compliqué c'est qu'on va pas dans la bonne direction
        if (n > 1) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
