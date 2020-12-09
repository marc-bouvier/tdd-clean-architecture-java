package fr.baldir.learn.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        int potentialDivisor = 2;
        if (n != 1) {
            while (n!=1) {
                while (n % potentialDivisor == 0) {
                    primeFactors.add(potentialDivisor);
                    n /= potentialDivisor;
                }
                potentialDivisor++;
            }

        }
        return primeFactors;
    }
}
