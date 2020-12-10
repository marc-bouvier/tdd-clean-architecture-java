package fr.baldir.learn.kata.bookstore;

import java.util.Date;

/**
 * Real non deterministic implementation. Used in production.
 */
public class RealDateProvider implements DateProvider {
    @Override
    public Date now() {
        return new Date();
    }
}