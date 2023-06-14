package builder;

import base.Route;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UserBuilder extends Route {

    protected RequestSpecification createUserRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(CREATE_USER_BASE_PATH).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification getUserByUsernameRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(GET_USER_BY_USERNAME_BASE_PATH).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification updateUserRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(UPDATE_USER_BASE_PATH).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification deleteUserRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(DELETE_USER_BASE_PATH).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification createListOfUsersUsingArrayRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(CREATE_LIST_OF_USERS_USING_ARRAY_BASE_PATH).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification createListOfUsersUsingListRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(CREATE_LIST_OF_USERS_USING_LIST_BASE_PATH).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification logsUserIntoTheSystemRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(LOGS_USER_INTO_THE_SYSTEM_BASE_PATH).
                log(LogDetail.ALL).build();
    }

    protected RequestSpecification logsOutFromCurrentSessionRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath(LOGS_OUT_FROM_CURRENT_SESSION_BASE_PATH).
                log(LogDetail.ALL).build();
    }

}
