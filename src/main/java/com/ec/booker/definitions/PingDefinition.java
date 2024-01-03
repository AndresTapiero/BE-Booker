package com.ec.booker.definitions;

import com.ec.booker.actions.*;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class PingDefinition {

    @Steps
    HealthCheckAction checkAction;

    @Given("do a request to the endpoint {string}")
    public void setCreateBookingAction(String endpoint) {
        checkAction.ping(endpoint);
    }

}
