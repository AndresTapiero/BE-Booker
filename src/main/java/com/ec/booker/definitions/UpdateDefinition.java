package com.ec.booker.definitions;

import com.ec.booker.actions.UpdateBookingAction;
import com.ec.booker.models.createbooking.BookingModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class UpdateDefinition {

    String token = LoginDefinition.token;
    @Steps
    UpdateBookingAction updateBookingAction;


    @Entonces("al actualizar validare los atributos")
    public void updateCompleteBooking() {
        BookingModel completeBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "updateCompleteBooking", BookingModel.class);
        updateBookingAction.updateCompleteBooking(token, completeBooking, (String.valueOf(CreateBookDefinition.id)));
    }

    @Entonces("al actualizar validare los atributos {string} y {string}")
    public void updatePartialBooking(String name, String lastname) {
        BookingModel partialBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "updatePartialBooking", BookingModel.class);
        updateBookingAction.updatePartialBooking(token, partialBooking, name, lastname, (String.valueOf(CreateBookDefinition.id)));
    }

}
