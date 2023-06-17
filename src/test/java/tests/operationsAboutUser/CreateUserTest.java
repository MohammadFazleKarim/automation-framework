package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

    @Test
    private void createAnUser() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildCreateUserPayload();
        userTestHelper.postCreateUser();
        userTestHelper.validateUserCreated();
    }

}
