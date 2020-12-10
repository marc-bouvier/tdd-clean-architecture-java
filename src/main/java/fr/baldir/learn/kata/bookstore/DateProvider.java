package fr.baldir.learn.kata.bookstore;

import java.util.Date;

/**
 * By using this interface we allow to choose how we want to choose at injection time how is implemented the fetch of
 * the current time. This way orchestration logic can depend on this abstraction instead of implementation details.
 */
public interface DateProvider {

    Date now();

}