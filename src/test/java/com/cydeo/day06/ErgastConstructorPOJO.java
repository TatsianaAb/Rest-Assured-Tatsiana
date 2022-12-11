package com.cydeo.day06;

import com.cydeo.pojo.ConstructorPOJO;
import com.cydeo.pojo.MRData;
import com.cydeo.utilities.ErgastAPITestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ErgastConstructorPOJO extends ErgastAPITestBase {
    /*
    - Given accept type is json
- When user send request /constructorStandings/1/constructors.json -
Then verify status code is 200
- And content type is application/json; charset=utf-8
- And total is 17
- And limit is 30
- And each constructor has constructorId
- And constructor has name
- And size of constructor is 17 (using with hasSize)
- And constructor IDs has “benetton”, “mercedes”,”team_lotus”
- And names are in same order by following list
     */

    @DisplayName("GET req to /constructorStandings/1/constructors.json POJO")
    @Test
    public void test1() {

        JsonPath jsonPath = get("/constructorStandings/1/constructors.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().jsonPath();

        MRData mrData = jsonPath.getObject("MRData", MRData.class);
        assertThat(mrData.getTotal(), is(17));
        assertThat(mrData.getLimit(), is(30));
        List<ConstructorPOJO> constructors = jsonPath.getList("MRData.ConstructorTable.Constructors", ConstructorPOJO.class);

        ArrayList<String> allConstructorIds = new ArrayList<>();
        for (ConstructorPOJO eachConstructor : constructors) {
            allConstructorIds.add(eachConstructor.getConstructorId());
        }

        for (String eachId : allConstructorIds) {
            assertThat(eachId, notNullValue());
        }

        ArrayList<String> allConstructorNames = new ArrayList<>();
        for (ConstructorPOJO eachConstructor : constructors) {
            allConstructorNames.add(eachConstructor.getName());
        }

        for (String eachName : allConstructorNames) {
            assertThat(eachName, notNullValue());
        }

        assertThat(constructors, hasSize(17));
        assertThat(allConstructorIds, hasItems("benetton", "mercedes", "team_lotus"));

        List<String> names = Arrays.asList("Benetton", "Brabham-Repco", "Brawn", "BRM", "Cooper-Climax", "Ferrari", "Lotus-Climax", "Lotus-Ford", "Matra-Ford", "McLaren", "Mercedes", "Red Bull", "Renault", "Team Lotus", "Tyrrell", "Vanwall", "Williams");

        assertThat(allConstructorNames, equalTo(names));


    }
}
