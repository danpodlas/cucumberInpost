package pl.dpodlaski.API;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import pl.dpodlaski.API.POJO.PointsPOJO;
import pl.dpodlaski.API.endpoints.GetPointsEndpoints;
import pl.dpodlaski.API.properties.EnvironmentConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.testng.AssertJUnit.assertTrue;

public class StepDefAPI {
    Map<String, Object> pathParams = new HashMap<>();
    List<PointsPOJO> pojoList;
    Response response;
    EnvironmentConfig environmentConfig;

    @Before
    public void setUp(){
        environmentConfig= ConfigFactory.create(EnvironmentConfig.class);
    }

    @Given("Użytkownik skonfigurował połączenie")
    public void użytkownikSkonfigurowałPołączenie() {


        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.basePath= environmentConfig.basePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @When("Użytwkonik wysyła żądanie o listę paczkomatów w Krakowie")
    public void użytwkonikWysyłaŻądanieOListęPaczkomatówWKrakowie() {
        pathParams.put("query", "30- Kraków");
        pathParams.put("type", "standard_parcel_collect");
        pathParams.put("page", "1");
        pathParams.put("perPage", "30");

        response = new GetPointsEndpoints().sendRequestGetPointInKrk();
    }

    @Then("Użytkownik pobiera listę paczkomatów")
    public void użytkownikPobieraListęPaczkomatów() {
        pojoList = response.then().extract().jsonPath().getList("items", PointsPOJO.class);
    }

    @And("Sprawdza czy wszystkie paczkomaty są z Krakowa")
    public void sprawdzaCzyWszystkiePaczkomatySąZKrakowa() {
        Pattern pattern = Pattern.compile("KRA");

        for (int i = 0; i < pojoList.size(); i++) {
            assertTrue(pattern.matcher(pojoList.get(i).getId()).find());
        }
    }


}
