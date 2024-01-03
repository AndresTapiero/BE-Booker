package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static com.ec.booker.utils.constants.Constants.BASE_URI;


public class CreateBookingAction {

    @Step
    public void createNewBooking(String endpoint, BookingModel bookingModel) {
       SerenityRest.given().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().post(endpoint);
    }

}
