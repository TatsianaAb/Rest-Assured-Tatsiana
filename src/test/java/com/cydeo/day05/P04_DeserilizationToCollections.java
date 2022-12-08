package com.cydeo.day05;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P04_DeserilizationToCollections extends SpartanTestBase {


     /*
     Given accept type is application/json
     And Path param id = 10
     When i send GET request to /api/spartans
     Then status code is 200
     And content type is json
     And spartan data matching:
         id > 10
         name>Lorenza
         gender >Female
         phone >3312820936
     */

    @Test
    public  void test1() {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10).
                when().get("/api/spartans/{id}").prettyPeek().
                then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();

        //Approach one ---> with Response

        Map<String,Object> spartanMap= response.as(Map.class);
        System.out.println("spartanMap = " + spartanMap);


    }
}
