package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateUserTest extends UserTestHelper {

    @Test
    private void createAnUser() {
        buildCreateUserPayload();
        postCreateUser();
        validateUserCreated();
    }

}
