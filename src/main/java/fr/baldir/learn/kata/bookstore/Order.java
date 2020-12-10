package fr.baldir.learn.kata.bookstore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
public class Order {

    private final String name;
    private final Date purchaseDate;

    public Order(String name, Date purchaseDate) {
        this.name = name;
        this.purchaseDate = purchaseDate;
    }
}