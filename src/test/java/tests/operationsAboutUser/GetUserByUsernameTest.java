package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class GetUserByUsernameTest extends UserTestHelper {

    @Test
    private void getUserByUsername() {
        buildCreateUserPayload();
        postCreateUser();
        validateUserCreated();

        getUserInfo();
        validateUserDetails();
    }

}
