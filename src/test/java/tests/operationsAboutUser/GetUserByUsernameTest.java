package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class GetUserByUsernameTest extends BaseTest {

    @Test
    private void getUserByUsername() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildCreateUserPayload();
        userTestHelper.postCreateUser();
        userTestHelper.validateUserCreated();

        userTestHelper.getUserInfo();
        userTestHelper.validateUserDetails();
    }

}
