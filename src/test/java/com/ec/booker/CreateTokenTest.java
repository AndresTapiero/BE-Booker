package com.ec.booker;

import com.ec.booker.Utils.file.JsonFiles;
import com.ec.booker.actions.LoginAction;
import com.ec.booker.models.LoginModel;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CreateTokenTest {

    @Steps
    LoginAction loginAction;

    @Test
    public void login() {
        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
        loginAction.postLogin(login);
    }

}
