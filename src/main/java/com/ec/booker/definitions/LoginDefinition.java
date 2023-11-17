package com.ec.booker.definitions;

import com.ec.booker.actions.HealthCheckAction;
import com.ec.booker.actions.LoginAction;
import com.ec.booker.models.LoginModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import static com.ec.booker.utils.constants.Constants.CREATED;

public class LoginDefinition {

    String token;
    @Steps
    LoginAction loginAction;

    @Dado("Que hago login")
    public void login() {
        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
        token = loginAction.getTokenLogin(login);
    }

    @Entonces("Validare que el token no sea null o vacio")
    public void validateToken() {
        Assert.assertNotNull("El token es nulo", token);
        Assert.assertFalse("El token está vacío", token.isEmpty());
    }

}
