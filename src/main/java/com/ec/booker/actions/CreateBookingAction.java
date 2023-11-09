package com.ec.booker.actions;

import com.ec.booker.models.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.Utils.constants.ServicesPaths.CREATE_BOOKING;


public class CreateBookingAction {

    int bookingId;
    @Step
    public void createNewBooking(BookingModel bookingModel) {
        String baseUrl = "https://restful-booker.herokuapp.com";
        SerenityRest.given().log().all().baseUri(baseUrl)
                .contentType(ContentType.JSON).body(bookingModel)
                .when().post(CREATE_BOOKING.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }
}
