package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class UpdateAnUserTest extends BaseTest {

    @Test
    private void updateAnUser() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildCreateUserPayload();
        userTestHelper.postCreateUser();
        userTestHelper.validateUserCreated();

        userTestHelper.buildUpdateUserPayload();
        userTestHelper.putUpdateUser();
        userTestHelper.validateUserUpdated();

        userTestHelper.getUserInfo();
        userTestHelper.validateUpdatedUserDetails();
    }

}
