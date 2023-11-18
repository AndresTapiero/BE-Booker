package com.ec.booker.definitions;

import com.ec.booker.actions.*;
import com.ec.booker.utils.file.JsonFiles;
import com.ec.booker.models.LoginModel;
import com.ec.booker.models.createbooking.BookingModel;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class HappyPathDefinition {

    private String token;

    private int id;

    private String name;

    @Steps
    LoginAction loginAction;

    @Steps
    CreateBookingAction createBookingAction;

    @Steps
    UpdateBookingAction updateBookingAction;

    @Steps
    GetBookingsAction getBookingsAction;

    @Steps
    DeleteBookingAction deleteBookingAction;


    LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
    BookingModel newBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "createNewBooking", BookingModel.class);
    BookingModel partialBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "updatePartialBooking", BookingModel.class);
    BookingModel completeBooking = JsonFiles.getObjectJava("./src/test/resources/data/", "updateCompleteBooking", BookingModel.class);



    @Cuando("cuando cree, actualice con nombre {string} y apellido {string}, elimine respondiendo {int}")
    public void updateBooking(String firstName, String lastName, int status) {

        token = loginAction.getTokenLogin(login);
        id = createBookingAction.createNewBooking(newBooking);
        updateBookingAction.updatePartialBooking(token, partialBooking, firstName,lastName, String.valueOf(id));
        updateBookingAction.updateCompleteBooking(token, completeBooking, String.valueOf(id));
        name = getBookingsAction.getBookingById(String.valueOf(id));
        Assert.assertEquals("Michi", name);
        deleteBookingAction.deleteBooking(token, status, String.valueOf(id));
    }

    @Entonces("validare que el flujo finalizo correctamente con mensaje {string}")
    public void validateDateById(String message) {
        System.out.println(message);
    }

}
