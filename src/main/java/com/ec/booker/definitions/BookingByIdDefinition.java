package com.ec.booker.definitions;

import com.ec.booker.actions.GetBookingsAction;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class BookingByIdDefinition {

    private String name;

    @Steps
    GetBookingsAction getBookingsAction;


    @Entonces("valide en el servicio booking por id")
    public void getBookingById() {
        int id = CreateBookDefinition.id;
        name = getBookingsAction.getBookingById(String.valueOf(id));
    }

    @Y("validare la respuesta por el nombre {string}")
    public void validateResponse(String firstname) {
        Assert.assertEquals(firstname, name);
    }

}
