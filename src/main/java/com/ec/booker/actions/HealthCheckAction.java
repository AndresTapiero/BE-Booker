package com.ec.booker.actions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;

import static com.ec.booker.utils.constants.Constants.BASE_URI;
import static com.ec.booker.utils.constants.ServicesPaths.PING;


public class HealthCheckAction {
    @Step
    public String ping(int status) {
       String response = SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(PING.getPath())
                .then()
                .statusCode(status).extract().response().getBody().asString();
        System.out.println("Response " + response);
       return response;
    }
}
