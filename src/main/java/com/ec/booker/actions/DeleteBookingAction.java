package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.Utils.constants.Constants.*;
import static com.ec.booker.Utils.constants.ServicesPaths.BOOKING;


public class DeleteBookingAction {

    @Step
    public void deleteBooking(String id) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION.getValue(), AUTHORIZATION_VALUE.getValue())
                .when().delete(BOOKING.getPath() + "/" +id)
                .then()
                .statusCode(HttpStatus.SC_CREATED).log().all();
    }
}
