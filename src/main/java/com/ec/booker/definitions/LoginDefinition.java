package com.ec.booker.definitions;

import com.ec.booker.actions.LoginAction;
import com.ec.booker.models.LoginModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class LoginDefinition {

    public static String token;
    @Steps
    LoginAction loginAction;

    @Dado("que hago login")
    public void login() {
        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
        token = loginAction.getTokenLogin(login);
    }

    @Entonces("validare que el token no sea null o vacio")
    public void validateToken() {
        Assert.assertNotNull("El token es nulo", token);
        Assert.assertFalse("El token está vacío", token.isEmpty());
    }

}
