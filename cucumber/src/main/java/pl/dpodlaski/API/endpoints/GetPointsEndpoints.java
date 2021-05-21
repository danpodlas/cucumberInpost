package pl.dpodlaski.API.endpoints;

import io.restassured.response.Response;
import pl.dpodlaski.API.POJO.PointsPOJO;
import pl.dpodlaski.API.request.configuration.RequestConfigurationBuilder;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetPointsEndpoints {

    Map<String, Object> pathParams = new HashMap<>();

    public Response sendRequestGetPointInKrk() {
        pathParams.put("query", "30- KRA");
        pathParams.put("type", "standard_parcel_collect");
        pathParams.put("page", "1");
        pathParams.put("perPage", "50");
        Response response = given().spec(RequestConfigurationBuilder.getDefaultRequestSpecification()).queryParams(pathParams)
                .when().get("v1/api/points").then().log().all().extract().response();
        return response;
    }


}
