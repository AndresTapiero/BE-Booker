package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.Utils.constants.Constants.BASE_URI;
import static com.ec.booker.Utils.constants.ServicesPaths.BOOKING;


public class GetBookingsAction {

    @Step
    public void getBookings() {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(BOOKING.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }


    @Step("Validate status 200")
    public BookingModel getBookingById(String id) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(BOOKING.getPath() + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
        return SerenityRest.lastResponse().as(BookingModel.class);
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
