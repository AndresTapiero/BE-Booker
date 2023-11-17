package com.ec.booker.definitions;

import com.ec.booker.actions.CreateBookingAction;
import com.ec.booker.models.createbooking.BookingModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class CreateBookDefinition {

    public static int id;

    @Steps
    CreateBookingAction createBookingAction;


    @Cuando("cree un nuevo book")
    public void setCreateBookingAction() {
        BookingModel newBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "createNewBooking", BookingModel.class);
        id = createBookingAction.createNewBooking(newBooking);
    }


    @Entonces("Validare que el bookingid no es nulo")
    public void validateBookingId() {
        Assert.assertNotNull("El id está vacío", id);
    }

}
