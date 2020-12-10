package fr.baldir.learn.kata.bookstore;

import java.util.Date;
import java.util.Objects;

public class Order {

    private final String name;
    private final Date purchaseDate;

    public Order(String name, Date purchaseDate) {
        this.name = name;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(name, order.name) &&
                Objects.equals(purchaseDate, order.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, purchaseDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", purchaseDate=" + purchaseDate.getTime() +
                '}';
    }
}