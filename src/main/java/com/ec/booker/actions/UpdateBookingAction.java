package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.Utils.constants.Constants.*;
import static com.ec.booker.Utils.constants.ServicesPaths.BOOKING;


public class UpdateBookingAction {

    @Step
    public void updateCompleteBooking(BookingModel bookingModel, String id) {
        SerenityRest.given().log().all()
                .header(AUTHORIZATION.getValue(),AUTHORIZATION_VALUE.getValue())
                .baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().put(BOOKING.getPath()+"/"+ id)
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }

    @Step
    public void updatePartialBooking(BookingModel bookingModel, String id) {
        SerenityRest.given().log().all()
                .header(AUTHORIZATION.getValue(), AUTHORIZATION_VALUE.getValue())
                .baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().patch(BOOKING.getPath()+"/"+ id)
                .then()
                .statusCode(HttpStatus.SC_OK).log().all().extract().jsonPath().get("firstname");
    }
}
