package com.ec.booker.definitions;

import com.ec.booker.actions.LoginAction;
import com.ec.booker.models.LoginModel;
import com.ec.booker.utils.file.JsonFiles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class LoginDefinition {

    public static String token;
    @Steps
    LoginAction loginAction;

    //TODO: DELETE
    @When("que hago login")
    public void login() {
        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/", "login", LoginModel.class);
        token = loginAction.getTokenLogin(login);
    }

    @When("a POST request is made with username {string} and password {string}")
    public void makePostRequest(String username, String password) {
        System.out.println("Envió " + username + " ");
        loginAction.doLogin(username, password);
    }

    @And("the response should contain a token")
    public void verifyResponseContainsToken() {
        loginAction.verifyResponseToken();
    }


    @And("the response should contain the text {string}")
    public void verifyResponseContainsText(String expectedText) {
        loginAction.verifyResponseContainsText(expectedText);
    }

    //TODO: DELETE
    @Entonces("validare que el token no sea null o vacio")
    public void validateToken() {
        Assert.assertNotNull("El token es nulo", token);
        Assert.assertFalse("El token está vacío", token.isEmpty());
    }

}
