package fr.baldir.learn.unit.kata.bookstore;

import fr.baldir.learn.kata.bookstore.BuyBook;
import fr.baldir.learn.kata.bookstore.DeterministicDateProvider;
import fr.baldir.learn.kata.bookstore.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class BuyBookTest {

    @Test
    void shouldByABookRightNow() {
        DeterministicDateProvider dateProvider =
                new DeterministicDateProvider(new Date(2020, 2, 3, 14, 5, 5));
        BuyBook buyBook = new BuyBook();
        buyBook.buy("Harry Potter", dateProvider);
        assertThat(buyBook.bought())
                .isEqualTo(new Order("Harry Potter", dateProvider.now()));
    }

}