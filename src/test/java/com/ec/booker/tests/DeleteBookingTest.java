package com.ec.booker.tests;

import com.ec.booker.Utils.file.JsonFiles;
import com.ec.booker.actions.CreateBookingAction;
import com.ec.booker.actions.DeleteBookingAction;
import com.ec.booker.models.createbooking.BookingModel;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DeleteBookingTest {

    @Steps
    DeleteBookingAction deleteBookingAction;

    @Test
    public void createBooking() {
        deleteBookingAction.deleteBooking("35");
    }
}
