package base;

public class Route extends DriverSetup {

    protected static String BASE_URI = requestUrlProperties.getProperty("base_uri");

    protected static String CREATE_USER_BASE_PATH = requestUrlProperties.getProperty("create_user");

    protected static String GET_USER_BY_USERNAME_BASE_PATH = requestUrlProperties.getProperty("get_user");

    protected static String UPDATE_USER_BASE_PATH = requestUrlProperties.getProperty("update_user");

    protected static String DELETE_USER_BASE_PATH = requestUrlProperties.getProperty("delete_user");

    protected static String CREATE_LIST_OF_USERS_USING_ARRAY_BASE_PATH = requestUrlProperties.getProperty("create_list_of_user_with_array");

    protected static String CREATE_LIST_OF_USERS_USING_LIST_BASE_PATH = requestUrlProperties.getProperty("create_list_of_user_with_list");

    protected static String LOGS_USER_INTO_THE_SYSTEM_BASE_PATH = requestUrlProperties.getProperty("logs_user");

    protected static String LOGS_OUT_FROM_CURRENT_SESSION_BASE_PATH = requestUrlProperties.getProperty("logs_out");

}
