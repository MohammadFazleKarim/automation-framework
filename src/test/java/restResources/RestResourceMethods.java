package restResources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RestResourceMethods {

    public static Response post(RequestSpecification requestSpecification, Object requestPayload) {
        return given(requestSpecification).
                body(requestPayload).
                contentType("application/json").
                when().
                post().
                then().
                log().all().extract().response();
    }

    public static Response put(RequestSpecification requestSpecification, Object requestPayload, String pathParameterName, Object pathParameterValue) {
        return given(requestSpecification).
                pathParam(pathParameterName, pathParameterValue).
                body(requestPayload).
                contentType("application/json").
                when().
                put().
                then().
                log().all().extract().response();
    }

    public static Response delete(RequestSpecification requestSpecification, String pathParameterName, Object pathParameterValue) {
        return given(requestSpecification).
                pathParam(pathParameterName, pathParameterValue).
                when().
                delete().
                then().
                log().all().extract().response();
    }

    public static Response get(RequestSpecification requestSpecification, String pathParameterName, Object pathParameterValue) {
        return given(requestSpecification).
                pathParam(pathParameterName, pathParameterValue).
                when().
                get().
                then().
                log().all().extract().response();
    }

    public static Response get(RequestSpecification requestSpecification, String firstQueryParameterName, Object firstQueryParameterValue, String secondQueryParameterName, Object secondQueryParameterValue) {
        return given(requestSpecification).
                queryParam(firstQueryParameterName, firstQueryParameterValue).
                queryParam(secondQueryParameterName, secondQueryParameterValue).
                when().
                get().
                then().
                log().all().extract().response();
    }

    public static Response get(RequestSpecification requestSpecification) {
        return given(requestSpecification).
                when().
                get().
                then().
                log().all().extract().response();
    }

}
