package tests.operationsAboutUser;

import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateListOfUsersUsingListTest extends UserTestHelper {

    @Test
    public void createListOfUsersUsingList() {
        buildListOfUsersUsingArrayPayload();
        postCreateListOfUsersUsingList();
        validateListOfUsersCreated();
    }

}
