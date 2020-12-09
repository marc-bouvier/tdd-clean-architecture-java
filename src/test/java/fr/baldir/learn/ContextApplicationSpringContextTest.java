package fr.baldir.learn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class ContextApplicationSpringContextTest {

    @SuppressWarnings("java:S2699")
    @Test void out_of_the_box_spring_application_context_should_not_fail(){
        //This test has no assertion, we want to see if spring context does not throw exception
    }
}
