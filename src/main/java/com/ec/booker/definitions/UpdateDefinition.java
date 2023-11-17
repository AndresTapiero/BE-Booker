package com.ec.booker.definitions;

import com.ec.booker.actions.LoginAction;
import com.ec.booker.actions.UpdateBookingAction;
import com.ec.booker.models.LoginModel;
import com.ec.booker.models.createbooking.BookingModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class UpdateDefinition {

    String token;
    @Steps
    UpdateBookingAction updateBookingAction;

    @Steps
    LoginAction loginAction;


    @Cuando("hago login")
    public void login() {
        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
        token = loginAction.getTokenLogin(login);
    }

    @Entonces("al actualizar validare los atributos")
    public void updateCompleteBooking() {
        BookingModel bookingModel = JsonFiles.getObjectJava("./src/test/resources/data/", "updateCompleteBooking", BookingModel.class);
        updateBookingAction.updateCompleteBooking(token, bookingModel, (String.valueOf(CreateBookDefinition.id)));
    }

    @Entonces("al actualizar validare los atributos nombre y apellido")
    public void updatePartialBooking() {
        BookingModel bookingModel = JsonFiles.getObjectJava("./src/test/resources/data/", "updatePartialBooking", BookingModel.class);
        updateBookingAction.updatePartialBooking(token, bookingModel, (String.valueOf(CreateBookDefinition.id)));
    }

}
