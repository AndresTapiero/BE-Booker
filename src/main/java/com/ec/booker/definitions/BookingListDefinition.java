package com.ec.booker.definitions;

import com.ec.booker.actions.GetBookingsAction;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class BookingListDefinition {

    Object[] bookingList;
    @Steps
    GetBookingsAction getBookingsAction;

    @Dado("que consulto el servicio para traer los bookingid")
    public void setCreateBookingAction() {
        bookingList = getBookingsAction.getBookingLists();
    }

    @Entonces("validare que la lista no venga vacia")
    public void validateResponse() {
        Assert.assertFalse("La lista de booking está vacía", bookingList.length == 0);
    }

}
