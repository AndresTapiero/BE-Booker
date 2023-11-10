package com.ec.booker;

import com.ec.booker.actions.PingAction;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class PingTest {

    @Steps
    PingAction pingAction;


    @Test
    public void login() {
        pingAction.ping();
    }

}
