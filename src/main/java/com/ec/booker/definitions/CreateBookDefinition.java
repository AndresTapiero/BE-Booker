package com.ec.booker.definitions;

import com.ec.booker.actions.CreateBookingAction;
import com.ec.booker.models.createbooking.BookingModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class CreateBookDefinition {

    public static int id;

    @Steps
    CreateBookingAction createBookingAction;


    @When("a POST request is made to {string} with the JSON {string}")
    public void setCreateBookingAction(String endpoint, String file) {
        BookingModel newBooking = JsonFiles.getObjectJava("./src/test/resources/data/", file, BookingModel.class);
       createBookingAction.createNewBooking(endpoint, newBooking);
    }


    @Then("Validare que el bookingid no es nulo")
    public void validateBookingId() {
        Assert.assertNotNull("El id está vacío", id);
    }

}
