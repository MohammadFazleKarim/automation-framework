package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class UpdateAnUserTest extends UserTestHelper {

    @Test
    private void updateAnUser() {
        buildCreateUserPayload();
        postCreateUser();
        validateUserCreated();

        buildUpdateUserPayload();
        putUpdateUser();
        validateUserUpdated();

        getUserInfo();
        validateUpdatedUserDetails();
    }

}
