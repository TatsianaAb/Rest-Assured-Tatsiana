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
        // Matchers hs 2 overloaded methods
        // - First one will take value to check
        // - Second one will take another Matcher to make it readable / to add new assert functionality
        assertThat(9, is(6+3));
        assertThat(9,is(equalTo(6+3)));
        assertThat(9,equalTo(6+3));

        /**
         * is(someValue)
         * is(equalTo(someValue))
         * equalTo(someValue)
         * All of them same in terms of assertion
         */

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(9))));

        /**
         * These 3 are same again
         */


        /**
         * greaterThan() lessThan()
         * greaterThanOrEqualTo() lessThanOrEqualTo()
         */

        assertThat(5+6,is(greaterThan(10)));
        assertThat(5+6,greaterThan(10));
        assertThat(5+5,lessThanOrEqualTo(10));

    }
}
