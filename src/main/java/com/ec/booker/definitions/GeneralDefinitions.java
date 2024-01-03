package com.ec.booker.definitions;

import com.ec.booker.actions.GeneralActions;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class GeneralDefinitions {

    @Steps
    GeneralActions generalActions;

    @Then("the response status code should be {int}")
    public void getStatusCode(int statusCode) {
        generalActions.verifyStatusCode(statusCode);
    }


    @Then("validate the response with a JSON Schema {string}")
    public void validateResponseWithAJSONSSchema(String jsonSchema) {
        generalActions.validateWithJsonSchema(jsonSchema);
    }
}
