package helper;

import builder.UserBuilder;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import enums.StatusCodes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasKey;
import static org.testng.Assert.*;

import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import restResources.RestResourceMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTestHelper extends UserBuilder {

    Faker faker = new Faker();

    private static int valueOfId = 0;
    private static String valueOfUsername = null;
    private static String valueOfFirstName = null;
    private static String valueOfLastName = null;
    private static String valueOfEmail = null;
    private static String valueOfPassword = null;
    private static String valueOfPhone = null;
    private static int valueOfUserStatus = 0;

    private static String updatedValueOfEmail = null;
    private static String updatedValueOfPassword = null;

    private JSONObject createUserJsonObject = null;
    private JSONObject updateUserJsonObject = null;
    private Response response = null;
    private static String listOfUserUsingArrayPayload = null;

    public void buildCreateUserPayload(){
        valueOfId = faker.random().nextInt(5, 500);
        valueOfUsername = faker.name().username();
        valueOfFirstName = faker.name().firstName();
        valueOfLastName = faker.name().lastName();
        valueOfEmail = faker.random().toString() + "@gmail.com";
        valueOfPassword = faker.random().toString();
        valueOfPhone = faker.phoneNumber().phoneNumber();
        valueOfUserStatus = faker.random().nextInt(0, 2);

        Map<String, Object> createUserPayload = new HashMap<>();
        createUserPayload.put("id", valueOfId);
        createUserPayload.put("username", valueOfUsername);
        createUserPayload.put("firstName", valueOfFirstName);
        createUserPayload.put("lastName", valueOfLastName);
        createUserPayload.put("email", valueOfEmail);
        createUserPayload.put("password", valueOfPassword);
        createUserPayload.put("phone", valueOfPhone);
        createUserPayload.put("userStatus", valueOfUserStatus);

        createUserJsonObject = new JSONObject(createUserPayload);
    }

    public void postCreateUser(){
        response =  RestResourceMethods.post(createUserRequestSpecification(), createUserJsonObject);
    }

    public void validateUserCreated(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);

        String actualValuefType = jsonPathEvaluator.get("type");
        assertEquals(actualValuefType, "unknown");

        String actualValueOfMessage = jsonPathEvaluator.get("message");
        assertEquals(actualValueOfMessage, Integer.toString(valueOfId));
    }

    public void getUserInfo(){
        response =  RestResourceMethods.get(getUserByUsernameRequestSpecification(), "username", valueOfUsername);
    }

    public void validateUserDetails(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 8 keys such as "id", "username", "firstName", "lastName", "email", "password", "phone" and "userStatus"
        validatableResponse.body("$", hasKey("id"));
        validatableResponse.body("$", hasKey("username"));
        validatableResponse.body("$", hasKey("firstName"));
        validatableResponse.body("$", hasKey("lastName"));
        validatableResponse.body("$", hasKey("email"));
        validatableResponse.body("$", hasKey("password"));
        validatableResponse.body("$", hasKey("phone"));
        validatableResponse.body("$", hasKey("userStatus"));

        // Are there 8 values for 8 keys
        validatableResponse.body("id", is(notNullValue()));
        validatableResponse.body("username", is(notNullValue()));
        validatableResponse.body("firstName", is(notNullValue()));
        validatableResponse.body("lastName", is(notNullValue()));
        validatableResponse.body("email", is(notNullValue()));
        validatableResponse.body("password", is(notNullValue()));
        validatableResponse.body("phone", is(notNullValue()));
        validatableResponse.body("userStatus", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfId = jsonPathEvaluator.get("id");
        assertEquals(actualValueOfId, valueOfId);
        assertEquals(jsonPathEvaluator.get("username"), valueOfUsername);
        assertEquals(jsonPathEvaluator.get("firstName"), valueOfFirstName);
        assertEquals(jsonPathEvaluator.get("lastName"), valueOfLastName);
//        assertEquals(jsonPathEvaluator.get("email"), valueOfEmail);
//        assertEquals(jsonPathEvaluator.get("password"), valueOfPassword);
        assertEquals(jsonPathEvaluator.get("phone"), valueOfPhone);
        int actualValueOfUserStatus = jsonPathEvaluator.get("userStatus");
        assertEquals(actualValueOfUserStatus, valueOfUserStatus);
    }

    public void validateUpdatedUserDetails(){
        ValidatableResponse validatableResponse = response.then();

        // Are there 8 keys such as "id", "username", "firstName", "lastName", "email", "password", "phone" and "userStatus"
        validatableResponse.body("$", hasKey("id"));
        validatableResponse.body("$", hasKey("username"));
        validatableResponse.body("$", hasKey("firstName"));
        validatableResponse.body("$", hasKey("lastName"));
        validatableResponse.body("$", hasKey("email"));
        validatableResponse.body("$", hasKey("password"));
        validatableResponse.body("$", hasKey("phone"));
        validatableResponse.body("$", hasKey("userStatus"));

        // Are there 8 values for 8 keys
        validatableResponse.body("id", is(notNullValue()));
        validatableResponse.body("username", is(notNullValue()));
        validatableResponse.body("firstName", is(notNullValue()));
        validatableResponse.body("lastName", is(notNullValue()));
        validatableResponse.body("email", is(notNullValue()));
        validatableResponse.body("password", is(notNullValue()));
        validatableResponse.body("phone", is(notNullValue()));
        validatableResponse.body("userStatus", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfId = jsonPathEvaluator.get("id");
        assertEquals(actualValueOfId, valueOfId);
        assertEquals(jsonPathEvaluator.get("username"), valueOfUsername);
        assertEquals(jsonPathEvaluator.get("firstName"), valueOfFirstName);
        assertEquals(jsonPathEvaluator.get("lastName"), valueOfLastName);
        assertEquals(jsonPathEvaluator.get("email"), updatedValueOfEmail);
        assertEquals(jsonPathEvaluator.get("password"), updatedValueOfPassword);
        assertEquals(jsonPathEvaluator.get("phone"), valueOfPhone);
        int actualValueOfUserStatus = jsonPathEvaluator.get("userStatus");
        assertEquals(actualValueOfUserStatus, valueOfUserStatus);
    }

    public void buildUpdateUserPayload(){
        updatedValueOfEmail = faker.random().toString() + "@gmail.com";
        updatedValueOfPassword = faker.random().toString();

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", valueOfId);
        payload.put("username", valueOfUsername);
        payload.put("firstName", valueOfFirstName);
        payload.put("lastName", valueOfLastName);
        payload.put("email", updatedValueOfEmail);
        payload.put("password", updatedValueOfPassword);
        payload.put("phone", valueOfPhone);
        payload.put("userStatus", valueOfUserStatus);

        updateUserJsonObject = new JSONObject(payload);
    }

    public void putUpdateUser(){
        response = RestResourceMethods.put(updateUserRequestSpecification(), updateUserJsonObject, "username", valueOfUsername);
    }

    public void validateUserUpdated(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);
        assertEquals(jsonPathEvaluator.get("type"), "unknown");
        assertEquals(jsonPathEvaluator.get("message"), Integer.toString(valueOfId));
    }

    public void deleteExistingUser() {
        response = RestResourceMethods.delete(deleteUserRequestSpecification(), "username", valueOfUsername);
    }

    public void validateUserDeleted() {
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);
        assertEquals(jsonPathEvaluator.get("type"), "unknown");
        assertEquals(jsonPathEvaluator.get("message"), valueOfUsername);
    }

    public void buildListOfUsersUsingArrayPayload(){
        valueOfId = faker.random().nextInt(5, 500);
        valueOfUsername = faker.name().username();
        valueOfFirstName = faker.name().firstName();
        valueOfLastName = faker.name().lastName();
        valueOfEmail = faker.random().toString() + "@gmail.com";
        valueOfPassword = faker.random().toString();
        valueOfPhone = faker.phoneNumber().phoneNumber();
        valueOfUserStatus = faker.random().nextInt(0, 2);

        Map<String, Object> payloadForFirstObject = new HashMap<>();
        payloadForFirstObject.put("id", valueOfId);
        payloadForFirstObject.put("username", valueOfUsername);
        payloadForFirstObject.put("firstName", valueOfFirstName);
        payloadForFirstObject.put("lastName", valueOfLastName);
        payloadForFirstObject.put("email", valueOfEmail);
        payloadForFirstObject.put("password", valueOfPassword);
        payloadForFirstObject.put("phone", valueOfPhone);
        payloadForFirstObject.put("userStatus", valueOfUserStatus);

        valueOfId = faker.random().nextInt(5, 500);
        valueOfUsername = faker.name().username();
        valueOfFirstName = faker.name().firstName();
        valueOfLastName = faker.name().lastName();
        valueOfEmail = faker.random().toString() + "@gmail.com";
        valueOfPassword = faker.random().toString();
        valueOfPhone = faker.phoneNumber().phoneNumber();
        valueOfUserStatus = faker.random().nextInt(0, 2);

        Map<String, Object> payloadForSecondObject = new HashMap<>();
        payloadForSecondObject.put("id", valueOfId);
        payloadForSecondObject.put("username", valueOfUsername);
        payloadForSecondObject.put("firstName", valueOfFirstName);
        payloadForSecondObject.put("lastName", valueOfLastName);
        payloadForSecondObject.put("email", valueOfEmail);
        payloadForSecondObject.put("password", valueOfPassword);
        payloadForSecondObject.put("phone", valueOfPhone);
        payloadForSecondObject.put("userStatus", valueOfUserStatus);

        valueOfId = faker.random().nextInt(5, 500);
        valueOfUsername = faker.name().username();
        valueOfFirstName = faker.name().firstName();
        valueOfLastName = faker.name().lastName();
        valueOfEmail = faker.random().toString() + "@gmail.com";
        valueOfPassword = faker.random().toString();
        valueOfPhone = faker.phoneNumber().phoneNumber();
        valueOfUserStatus = faker.random().nextInt(0, 2);

        Map<String, Object> payloadForThirdObject = new HashMap<>();
        payloadForThirdObject.put("id", valueOfId);
        payloadForThirdObject.put("username", valueOfUsername);
        payloadForThirdObject.put("firstName", valueOfFirstName);
        payloadForThirdObject.put("lastName", valueOfLastName);
        payloadForThirdObject.put("email", valueOfEmail);
        payloadForThirdObject.put("password", valueOfPassword);
        payloadForThirdObject.put("phone", valueOfPhone);
        payloadForThirdObject.put("userStatus", valueOfUserStatus);

        List<Map<String, Object>> arrayOfObjects = new ArrayList<>();
        arrayOfObjects.add(payloadForFirstObject);
        arrayOfObjects.add(payloadForSecondObject);
        arrayOfObjects.add(payloadForThirdObject);

        Gson gson = new Gson();
        listOfUserUsingArrayPayload = gson.toJson(arrayOfObjects);
    }

    public void postCreateListOfUsersUsingArray(){
        response = RestResourceMethods.post(createListOfUsersUsingArrayRequestSpecification(), listOfUserUsingArrayPayload);
    }

    public void validateListOfUsersCreated(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);
        assertEquals(jsonPathEvaluator.get("type"), "unknown");
        assertEquals(jsonPathEvaluator.get("message"), "ok");
    }

    public void postCreateListOfUsersUsingList(){
        response = RestResourceMethods.post(createListOfUsersUsingListRequestSpecification(), listOfUserUsingArrayPayload);
    }

    public void getUserLoggedIn(){
        String adminUserName = faker.name().username() + "@hub.com";
        String adminPassword = faker.random().hex(10);
        response = RestResourceMethods.get(logsUserIntoTheSystemRequestSpecification(), "username", adminUserName, "password", adminPassword);
    }

    public void validateUserIsLoggedIn(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);

        String actualValueOfType = jsonPathEvaluator.get("type");
        assertEquals(actualValueOfType, "unknown");

        // We are returning the value of "message" key --> "logged in user session:1676394250060"
        String actualValueOfMessage = jsonPathEvaluator.get("message");
        boolean isMessageExists = actualValueOfMessage.contains("logged in user session");
        assertTrue(isMessageExists);
    }

    public void getUserLoggedOutFromCurrentSession(){
        response = RestResourceMethods.get(logsOutFromCurrentSessionRequestSpecification());
    }

    public void validateUserLoggedOutFromCurrentSession(){
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(StatusCodes.CODE_200.code);

        // Are there 3 keys such as "code", "type" and "message"
        validatableResponse.body("$", hasKey("code"));
        validatableResponse.body("$", hasKey("type"));
        validatableResponse.body("$", hasKey("message"));

        // Are there 3 values for 3 keys
        validatableResponse.body("code", is(notNullValue()));
        validatableResponse.body("type", is(notNullValue()));
        validatableResponse.body("message", is(notNullValue()));

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Are the values for the particular keys are matching or valid?
        int actualValueOfCode = jsonPathEvaluator.get("code");
        assertEquals(actualValueOfCode, 200);
        assertEquals(jsonPathEvaluator.get("type"), "unknown");
        assertEquals(jsonPathEvaluator.get("message"), "ok");
    }

}
