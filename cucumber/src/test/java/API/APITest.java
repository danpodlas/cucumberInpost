package API;

import API.request.configuration.RequestConfigurationBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest extends TestBaseAPI{

    @Test()
    public void firstTest() {
        given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification())
                .when().get()
                .then().statusCode(200).log().all();
    }

}
