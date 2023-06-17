package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {

    @Test
    private void deleteAnUser() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildCreateUserPayload();
        userTestHelper.postCreateUser();
        userTestHelper.validateUserCreated();

        userTestHelper.deleteExistingUser();
        userTestHelper.validateUserDeleted();
    }

}
