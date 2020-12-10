package fr.baldir.learn.kata.bookstore;


import java.util.Date;

/**
 * Provider that allows to easily test an IO which is usually non deterministic.
 */
public class DeterministicDateProvider implements DateProvider {

    private Date now;

    public DeterministicDateProvider(Date now) {
        this.now = now;
    }

    @Override
    public Date now() {
        return now;
    }
}