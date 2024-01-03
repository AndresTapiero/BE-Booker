package com.ec.booker.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.*;


public class GeneralActions {

    @Step
    public void verifyStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Step
    public void validateWithJsonSchema(String jsonSchema) {
       then().assertThat().body(matchesJsonSchemaInClasspath("schemas/" + jsonSchema + ".json"));
    }
}
