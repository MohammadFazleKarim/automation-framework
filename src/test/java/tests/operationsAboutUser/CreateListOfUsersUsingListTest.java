package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateListOfUsersUsingListTest extends BaseTest {

    @Test
    public void createListOfUsersUsingList() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildListOfUsersUsingArrayPayload();
        userTestHelper.postCreateListOfUsersUsingList();
        userTestHelper.validateListOfUsersCreated();
    }

}
