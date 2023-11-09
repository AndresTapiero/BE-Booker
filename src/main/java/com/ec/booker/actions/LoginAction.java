package com.ec.booker.actions;



import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import com.ec.booker.models.LoginModel;

import static com.ec.booker.Utils.constants.ServicesPaths.LOGIN;

public class LoginAction {

    @Step
    public void postLogin(LoginModel login){
        String baseUrl = "https://restful-booker.herokuapp.com";
        SerenityRest.given().log().all().baseUri(baseUrl)
                .contentType(ContentType.JSON).body(login)
                .when().post(LOGIN.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).log().all();
    }
}
