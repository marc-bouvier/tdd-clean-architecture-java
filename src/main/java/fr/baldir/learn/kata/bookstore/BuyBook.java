package fr.baldir.learn.kata.bookstore;


public class BuyBook {

    private Order order;

    public void buy(String bookName, DateProvider dateProvider) {
        this.order = new Order(bookName, dateProvider.now());
    }

    public Order bought() {
        return order;
    }


}