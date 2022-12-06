package com.cydeo.day04;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P01_HRWithJsonPath extends HrTestBase {


    /*
    Given accept type is application/json
    And query param limit is 200
    When user send request /employees
    Then user should see ............

     */

    @DisplayName("Get All /employees?limit=200 --> JSONPATH ")
    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and() // it increases readablitity
                .queryParam("limit", 200).
                when().get("/employees");


        response.prettyPrint();


    }
}
