import Utils.file.JsonFiles;
import actions.LoginAction;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import models.Login;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static Utils.constants.ServicesPaths.LOGIN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class ReqRestTest {


    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        //RestAssured.basePath = "";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }


    @Test
    public void loginTest(){
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .post(LOGIN.getPath())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("token", notNullValue());

    }

    @Test
    public void loginSerenityTest(){

        Login login = JsonFiles.getObjectJava("./src/test/resources/data/","login", Login.class);
        SerenityRest.given().contentType(ContentType.JSON).body(login)
                .post("auth")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("token", notNullValue());

    }

}
