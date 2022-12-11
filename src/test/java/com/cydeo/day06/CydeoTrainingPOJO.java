package com.cydeo.day06;

import com.cydeo.pojo.Student;
import com.cydeo.pojo.Students;
import com.cydeo.utilities.CydeoTrainingTestBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class CydeoTrainingPOJO extends CydeoTrainingTestBase {

    @DisplayName("GET single student info from /student/{studentId}")
    @Test
    public void test1() {


        Response response = given()
                .accept(ContentType.JSON)
                .and().pathParam("studentId", 2)
                .when().get("/student/{studentId}")
                .then().statusCode(200)
                .contentType("application/json;charset=UTF-8")
                .header("transfer-encoding", "chunked")
                .header("date", notNullValue())
                .and().extract().response();


        Students students = response.as(Students.class);
        System.out.println(students);

        Student student1 = students.getStudents().get(0);
        System.out.println(student1);

        assertThat(student1.getFirstName(), equalTo("Mark"));
        assertThat(student1.getBatch(), is(13));
        assertThat(student1.getMajor(), is("math"));
        assertThat(student1.getContact().getEmailAddress(), is("mark@email.com"));
        assertThat(student1.getCompany().getCompanyName(), equalTo("Cydeo"));
        assertThat(student1.getCompany().getAddress().getStreet(), equalTo("777 5th Ave"));
        assertThat(student1.getCompany().getAddress().getZipCode(), is(33222));
    }
}
/*
 Send a GET req to student id 2 as a path parameter
 and accept header application/json
 verify status code = 200
 content-type = application/json;charset=UTF-8
 transfer-encoding = chunked
 Verify date header exists
 assert that:
 firstName - Mark
 batch - 13
 major - math
 emailAddress - mark@email.com
 companyName - Cydeo
 street - 777 5th Ave
 zipCode - 33222
 POJO
 */
