package com.ec.booker.definitions;

import com.ec.booker.actions.DeleteBookingAction;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class DeleteDefinition {

    String token;
    @Steps
    DeleteBookingAction deleteBookingAction;

    @Entonces("al eliminar mostrara el status Created")
    public void updateCompleteBooking() {
        token = UpdateDefinition.token;
        deleteBookingAction.deleteBooking(token, String.valueOf(CreateBookDefinition.id));
    }

}
