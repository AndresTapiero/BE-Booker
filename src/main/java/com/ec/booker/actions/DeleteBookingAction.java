package com.ec.booker.actions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.utils.constants.Constants.*;
import static com.ec.booker.utils.constants.ServicesPaths.BOOKING;
import static org.hamcrest.Matchers.equalTo;


public class DeleteBookingAction {

    @Step
    public void deleteBooking(String token, int status,String id) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .header(COOKIE.getValue(), TOKEN_EQUAL.getValue() + token)
                .when().delete(BOOKING.getPath() + "/" + id)
                .then()
                .statusCode(status).log().all()
                .assertThat();
    }
}
