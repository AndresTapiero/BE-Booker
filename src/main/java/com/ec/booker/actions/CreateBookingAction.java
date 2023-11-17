package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import static com.ec.booker.utils.constants.Constants.BASE_URI;
import static com.ec.booker.utils.constants.Constants.BOOKING_ID;
import static com.ec.booker.utils.constants.ServicesPaths.BOOKING;


public class CreateBookingAction {

    @Step
    public int createNewBooking(BookingModel bookingModel) {
        int id = SerenityRest.given().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().post(BOOKING.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all()
                .extract().jsonPath().get(BOOKING_ID.getValue());
        return id;
    }
}
