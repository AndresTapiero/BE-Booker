package com.ec.booker;

import com.ec.booker.Utils.file.JsonFiles;
import com.ec.booker.actions.UpdateBookingAction;
import com.ec.booker.models.createbooking.BookingModel;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UpdateBookingTest {

    @Steps
    UpdateBookingAction updateBookingAction;

    @Test
    public void updateBooking() {
        BookingModel bookingModel = JsonFiles.getObjectJava("./src/test/resources/data/", "updateCompleteBooking", BookingModel.class);
        updateBookingAction.updateCompleteBooking(bookingModel, "1089");
    }

    @Test
    public void updatePartialBooking() {
        BookingModel bookingModel = JsonFiles.getObjectJava("./src/test/resources/data/", "updatePartialBooking", BookingModel.class);
        updateBookingAction.updatePartialBooking(bookingModel, "850");
    }
}
