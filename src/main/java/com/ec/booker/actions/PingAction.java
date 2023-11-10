package com.ec.booker.actions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import static com.ec.booker.Utils.constants.Constants.BASE_URI;
import static com.ec.booker.Utils.constants.Constants.CREATED;
import static com.ec.booker.Utils.constants.ServicesPaths.PING;


public class PingAction {
    @Step
    public void ping() {
       String response = SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON)
                .when().get(PING.getPath())
                .then()
                .statusCode(HttpStatus.SC_CREATED).extract().response().getBody().asString();

        Assert.assertEquals(CREATED.getValue(), response);

    }
}
