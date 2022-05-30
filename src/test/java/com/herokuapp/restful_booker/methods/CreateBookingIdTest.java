package com.herokuapp.restful_booker.methods;
/* 
 Created by Kalpesh Patel
 */

import com.herokuapp.restful_booker.model.HerokuappPojo;
import com.herokuapp.restful_booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateBookingIdTest extends TestBase {

    @Test
    public void createNewBooking() {
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");

        HerokuappPojo herokuappPojo = new HerokuappPojo();
        herokuappPojo.setFirstname("Jim");
        herokuappPojo.setLastname("Brown");
        herokuappPojo.setTotalprice(145);
        herokuappPojo.setDepositpaid(true);
        herokuappPojo.setBookingdates(bookingsDatesData);
        herokuappPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(herokuappPojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}
