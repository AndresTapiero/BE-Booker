package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import static com.ec.booker.Utils.constants.Constants.BASE_URI;
import static com.ec.booker.Utils.constants.ServicesPaths.BOOKING;


public class CreateBookingAction {

    @Step
    public void createNewBooking(BookingModel bookingModel) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().post(BOOKING.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }
}
