package fr.baldir.learn.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {


    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        if(n==2)
            primeFactors.add(2);
        return primeFactors;
    }
}
