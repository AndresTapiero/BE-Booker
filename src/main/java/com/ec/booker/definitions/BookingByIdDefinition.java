package com.ec.booker.definitions;

import com.ec.booker.actions.CreateBookingAction;
import com.ec.booker.actions.GetBookingsAction;
import com.ec.booker.models.createbooking.BookingModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class BookingByIdDefinition {

    private String name;
    Object[] bookingList;
    @Steps
    GetBookingsAction getBookingsAction;

    @Cuando("Valide en el servicio booking por id")
    public void getBookingById() {
        int id = CreateBookDefinition.id;
        name = getBookingsAction.getBookingById(String.valueOf(id));
    }


    @Entonces("Validare la respuesta por el firstname")
    public void validateResponse() {
        Assert.assertEquals("Tom", name);
    }

}
