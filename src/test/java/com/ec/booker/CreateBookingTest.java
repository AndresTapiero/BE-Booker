package com.ec.booker;

import com.ec.booker.Utils.file.JsonFiles;
import com.ec.booker.actions.CreateBookingAction;
import com.ec.booker.models.BookingModel;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CreateBookingTest {

    @Steps
    CreateBookingAction createBookingAction;

    @Test
    public void createBooking(){
        BookingModel bookingModel = JsonFiles.getObjectJava("./src/test/resources/data/", "createNewBooking", BookingModel.class);
        createBookingAction.createNewBooking(bookingModel);
    }
}
