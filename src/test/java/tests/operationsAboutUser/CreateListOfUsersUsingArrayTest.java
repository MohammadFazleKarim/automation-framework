package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateListOfUsersUsingArrayTest extends UserTestHelper {

    @Test
    public void createListOfUsersUsingArray() {
        buildListOfUsersUsingArrayPayload();
        postCreateListOfUsersUsingArray();
        validateListOfUsersCreated();
    }

}
