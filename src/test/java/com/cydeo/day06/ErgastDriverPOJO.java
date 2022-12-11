package com.cydeo.day06;

import com.cydeo.pojo.ErgastDriver;
import com.cydeo.pojo.MRData;
import com.cydeo.utilities.ErgastAPITestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.RescaleOp;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ErgastDriverPOJO extends ErgastAPITestBase {
    /*
 - Given accept type is json
- And path param driverId is alonso
- When user send request /drivers/{driverId}.json
- Then verify status code is 200
- And content type is application/json; charset=utf-8 - And total is 1
- And givenName is Fernando
- And familyName is Alonso
- And nationality is Spanish
     */
    @DisplayName("Ergast Get req to /drivers/{driverId}.json POJO ")
    @Test
    public void test(){

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .pathParam("driverId", "alonso")
                .when().get("/drivers/{driverId}.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response().jsonPath();

        ErgastDriver driver = jsonPath.getObject("MRData.DriverTable.Drivers[0]", ErgastDriver.class);
        MRData mrData = jsonPath.getObject("MRData", MRData.class);
        assertThat(mrData.getLimit(), is(30));
        assertThat(mrData.getTotal(), is(1));
        assertThat(driver.givenName, equalTo("Fernando"));
        assertThat(driver.familyName, equalTo("Alonso"));
        assertThat(driver.getNationality(), is("Spanish"));
    }
}
