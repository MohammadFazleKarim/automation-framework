package base;

public class Route {

    protected static final String BASE_URI = "https://petstore.swagger.io/v2";

    protected static final String CREATE_USER_BASE_PATH = "/user";

    protected static final String GET_USER_BY_USERNAME_BASE_PATH = "/user/{username}";

    protected static final String UPDATE_USER_BASE_PATH = "/user/{username}";

    protected static final String DELETE_USER_BASE_PATH = "/user/{username}";

    protected static final String CREATE_LIST_OF_USERS_USING_ARRAY_BASE_PATH = "/user/createWithArray";

    protected static final String CREATE_LIST_OF_USERS_USING_LIST_BASE_PATH = "/user/createWithList";

    protected static final String LOGS_USER_INTO_THE_SYSTEM_BASE_PATH = "/user/login";

    protected static final String LOGS_OUT_FROM_CURRENT_SESSION_BASE_PATH = "/user/logout";

}
