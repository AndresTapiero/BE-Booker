package com.ec.booker.actions;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.*;


public class GeneralActions {

    @Step
    public void verifyStatusCode(int statusCode) {
        then().statusCode(statusCode);
    }

    @Step
    public void validateWithJsonSchema(String jsonSchema) {
       then().assertThat().body(matchesJsonSchemaInClasspath("schemas/" + jsonSchema + ".json"));
    }

    @Step
    public void validateText(String message) {
        String text = then().extract().response().getBody().asString();
        Assert.assertEquals(text, message);
    }
}
