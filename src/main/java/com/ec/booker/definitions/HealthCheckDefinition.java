package com.ec.booker.definitions;

import com.ec.booker.actions.*;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import static com.ec.booker.utils.constants.Constants.CREATED;

public class HealthCheckDefinition {

    String status;
    @Steps
    HealthCheckAction checkAction;

    @Dado("Que hago ping al endpointcon con respuesta 201")
    public void setCreateBookingAction() {
        status = checkAction.ping();
    }

    @Entonces("Validare el mensaje created")
    public void validateResponse() {
        Assert.assertEquals(CREATED.getValue(), status);
    }

}
