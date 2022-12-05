package com.cydeo.day03;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P01_SpartanWithPathParam extends SpartanTestBase {

    /*   Given accept type is Json
        And Id parameter value is 24
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 200
        And response content-type: application/json
        And "Julio" should be in response payload(body)
     */
    @DisplayName("GET Spartan /api/spartans/{id} path param with 24  ")
    @Test
    public void test1() {


        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 24).
                when().get("/api/spartans/{id}");

        response.prettyPrint();


        //Then response status code should be 200
       assertEquals(HttpStatus.SC_OK,response.statusCode());
        //no difference between line 36 and 38
        assertEquals(200,response.statusCode());

        //And response content-type: application/json
        assertEquals("application/json",response.contentType());
        //no difference between line 40 and 42
        assertEquals(ContentType.JSON.toString(),response.contentType());

        //And "Julio" should be in response payload(body)
        assertTrue(response.body().asString().contains("Julio"));


    }




}
