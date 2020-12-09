package fr.baldir.learn.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<>();

            for (int potentialDivisor = 2;n!=1;potentialDivisor++) {
                while (n % potentialDivisor == 0) {
                    primeFactors.add(potentialDivisor);
                    n /= potentialDivisor;
                }

        }
        return primeFactors;
    }
}
