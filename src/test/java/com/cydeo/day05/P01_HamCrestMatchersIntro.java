package com.cydeo.day05;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class P01_HamCrestMatchersIntro {


    @Test
    public void numbers() {
        // it comes from Junit5 to make assertions
        assertEquals(9,3+6);

        // Hamcrest Matchers comes from RestAssured dependency
        // import static org.hamcrest.MatcherAssert.*;
        // import static org.hamcrest.Matchers.*;
        // Adding following static import we are not gonna us classnames
        // while we are calling method from related classes
        assertThat(9, is(6+3));

        assertThat(9,is(equalTo(6+3)));

        assertThat(9,equalTo(6+3));

        /**
         * is(someValue)
         * is(equalTo(someValue))
         * equalTo(someValue)
         */


    }
}
