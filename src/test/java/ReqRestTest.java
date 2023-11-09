import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class ReqRestTest {


    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/auth")
                .then().extract().asString();

        System.out.println(response);

    }
}
