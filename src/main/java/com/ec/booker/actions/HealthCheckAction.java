package com.ec.booker.actions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static com.ec.booker.utils.constants.Constants.BASE_URI;



public class HealthCheckAction {
    @Step
    public void ping(String endpoint) {
        SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(endpoint);
    }

}
