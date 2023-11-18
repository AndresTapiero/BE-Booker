package com.ec.booker.definitions;

import com.ec.booker.actions.*;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class HealthCheckDefinition {

    String response;
    @Steps
    HealthCheckAction checkAction;

    @Dado("que hago ping al endpoint con respuesta {int}")
    public void setCreateBookingAction(int status) {
        response = checkAction.ping(status);
    }

    @Entonces("validare el mensaje {string}")
    public void validateResponse(String message) {
        Assert.assertEquals(message, response);
    }

}
