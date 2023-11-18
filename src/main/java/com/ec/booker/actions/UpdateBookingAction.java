package com.ec.booker.actions;

import com.ec.booker.models.createbooking.BookingModel;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import static com.ec.booker.utils.constants.Constants.*;
import static com.ec.booker.utils.constants.ServicesPaths.BOOKING;
import static org.hamcrest.Matchers.equalTo;


public class UpdateBookingAction {

    @Step
    public void updateCompleteBooking(String token, BookingModel bookingModel, String id) {
        SerenityRest.given().log().all()
                .header(COOKIE.getValue(), TOKEN_EQUAL.getValue() + token)
                .baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().put(BOOKING.getPath()+"/"+ id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(FIRST_NAME.getValue(), equalTo("Michi"))
                .body(LAST_NAME.getValue(), equalTo("Sawyer"))
                .body(TOTAL_PRICE.getValue(), equalTo(115))
                .body(ADDITIONAL_NEEDS.getValue(), equalTo("Breakfast"));
    }

    @Step
    public void updatePartialBooking(String token, BookingModel bookingModel, String name, String lastname, String id) {
        SerenityRest.given()
                .header(COOKIE.getValue(), TOKEN_EQUAL.getValue() + token)
                .baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(bookingModel)
                .when().patch(BOOKING.getPath()+"/"+ id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(FIRST_NAME.getValue(), equalTo(name))
                .body(LAST_NAME.getValue(), equalTo(lastname))
                .log().all();
    }
}
