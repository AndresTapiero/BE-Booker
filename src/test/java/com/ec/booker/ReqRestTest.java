package com.ec.booker;

import com.ec.booker.Utils.file.JsonFiles;
import com.ec.booker.models.LoginModel;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;


@RunWith(SerenityRunner.class)
public class ReqRestTest {

 int bookingCreated;
/*    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        //RestAssured.basePath = "";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }*/


/*    @Test
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

    }*/

    @Test
    public void loginSerenityTest(){

        LoginModel login = JsonFiles.getObjectJava("./src/test/resources/data/","login", LoginModel.class);
        SerenityRest.given().contentType(ContentType.JSON).body(login)
                .post("auth")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("token", notNullValue());

    }

/*
    @Test
    public void createBookingTest(){
        bookingCreated = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Pedro\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .post("booking")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("bookingid");

        System.out.println("id created id " + bookingCreated);

    }

    @Test
    public void getByIDTest(){
        given()
                .contentType(ContentType.JSON)
                .get("booking/1")
                .then()
                .statusCode(200)
                .body("bookingdates.checkin", equalTo("2018-11-04"));

    }


    @Test
    public void deleteByIDTest(){
        given()
                .contentType(ContentType.JSON)
                .delete("booking/1")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void patchByIDTest(){
        String nameUpdated = given()
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when().body("{\n" +
                        "    \"firstname\" : \"Michi\",\n" +
                        "    \"lastname\" : \"Brown\"\n" +
                        "}")
                .patch("booking/651")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("firstname");

        System.out.println("-----***" + nameUpdated);

    }


    @Test
    public void putByIDTest(){
        String nameUpdated = given()
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when().body("{\n" +
                        "    \"firstname\" : \"Jame\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 112,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .put("booking/651")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("firstname");

        System.out.println("-----***" + nameUpdated);

    }
*/



}
