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
        Assert.assertEquals("Tom", name);
    }

    @Y("validare la respuesta por el firstname")
    public void validateResponse() {
        Assert.assertEquals("Tom", name);
    }

}
