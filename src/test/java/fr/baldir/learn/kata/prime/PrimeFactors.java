package fr.baldir.learn.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        // On est passé d'une constante à une variable
        if (n > 1) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
