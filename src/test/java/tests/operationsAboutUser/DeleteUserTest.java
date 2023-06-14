package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class DeleteUserTest extends UserTestHelper {

    @Test
    private void deleteAnUser() {
        buildCreateUserPayload();
        postCreateUser();
        validateUserCreated();

        deleteExistingUser();
        validateUserDeleted();
    }

}
