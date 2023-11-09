package com.ec.booker;

import com.ec.booker.actions.GetBookingsAction;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetBookingsTest {


    @Steps
    GetBookingsAction getBookingsAction;

    @Test
    public void getBookings() {
        getBookingsAction.getBookings();
    }
}
