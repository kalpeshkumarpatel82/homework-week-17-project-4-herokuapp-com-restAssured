package com.herokuapp.restful_booker.methods;
/* 
 Created by Kalpesh Patel
 */

import com.herokuapp.restful_booker.model.HerokuappPojo;
import com.herokuapp.restful_booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateAuthTest extends TestBase {
    @Test
    public void createAuth() {
        HerokuappPojo herokuappPojo = new HerokuappPojo();
        herokuappPojo.setUsername("admin");
        herokuappPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(herokuappPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
