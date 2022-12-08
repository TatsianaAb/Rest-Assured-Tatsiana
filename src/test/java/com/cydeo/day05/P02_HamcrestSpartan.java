package com.cydeo.day05;

import com.cydeo.utilities.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class P02_HamcrestSpartan extends SpartanTestBase {

    /*
    Given accept type is Json
    And path param id is 15
    When user sends a get request to spartans/{id}
    Then status code is 200
    And content type is Json
    And json data has following
        "id": 15,
        "name": "Meta",
        "gender": "Female",
        "phone": 1938695106
     */
    @DisplayName("Get Single Spartan with Hamcrest")
    @Test
    public void test1() {


    }
}
