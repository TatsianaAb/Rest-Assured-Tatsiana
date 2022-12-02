package com.cydeo.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class P01_SpartanGetRequests {
    String url = "http://3.80.111.193:8000";


    /*
     * Given accept  content type is application/json
     * When user sends GET request /api/spartans endpoint
     * Then status code should be 200
     * And Content type should be application/json
     */

    @Test
    public void getAllSpartans() {

        Response response =RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get(url + "/api/spartans");

        // print response
        response.prettyPrint();


        // how to get status code
        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(200,actualStatusCode);

        //how can we get ContentType
        String actualContentType = response.contentType();

        Assertions.assertEquals("application/json",actualContentType);

    }
}
