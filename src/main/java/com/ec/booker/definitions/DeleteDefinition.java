package com.ec.booker.definitions;

import com.ec.booker.actions.DeleteBookingAction;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class DeleteDefinition {

    String token = LoginDefinition.token;;
    @Steps
    DeleteBookingAction deleteBookingAction;

    @Entonces("al eliminar mostrara el status {int} Created")
    public void updateCompleteBooking(int status) {
        deleteBookingAction.deleteBooking(token, status, String.valueOf(CreateBookDefinition.id));
    }

}
