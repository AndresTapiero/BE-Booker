package com.ec.booker.actions;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.utils.constants.Constants.BASE_URI;
import static com.ec.booker.utils.constants.Constants.FIRST_NAME;
import static com.ec.booker.utils.constants.ServicesPaths.BOOKING;


public class GetBookingsAction {

    @Step
    public Object[] getBookingLists() {
        Object[] list = new ValidatableResponse[]{SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(BOOKING.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all()};

        return list;
    }


    @Step("Validate status 200")
    public String getBookingById(String id) {
      String name = SerenityRest.given().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(BOOKING.getPath() + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK).log().all()
                .extract().jsonPath().get(FIRST_NAME.getValue());
      return name;
    }

    @Step
    public void getBookingByName(String name, String lastName) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(BOOKING.getPath() + "?" + "firstname=" + name + "&lastname=" + lastName)
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }
}
