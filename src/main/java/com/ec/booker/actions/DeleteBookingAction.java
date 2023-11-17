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
    public void deleteBooking(String token, String id) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .header(COOKIE.getValue(), "token=" + token)
                .when().delete(BOOKING.getPath() + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_CREATED).log().all()
                .assertThat();
    }
}
