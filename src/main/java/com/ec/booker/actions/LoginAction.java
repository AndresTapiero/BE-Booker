package com.ec.booker.actions;



import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import com.ec.booker.models.LoginModel;
import static com.ec.booker.utils.constants.Constants.BASE_URI;
import static com.ec.booker.utils.constants.Constants.TOKEN;
import static com.ec.booker.utils.constants.ServicesPaths.LOGIN;

public class LoginAction {

    @Step
    public String getTokenLogin(LoginModel login) {
      String token = SerenityRest.given().log().all().baseUri(BASE_URI.getValue())
                .contentType(ContentType.JSON).body(login)
                .when().post(LOGIN.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK).extract().jsonPath().get(TOKEN.getValue());
      return token;
    }
}
