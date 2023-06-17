package tests.operationsAboutUser;

import base.BaseTest;
import helper.UserTestHelper;
import org.testng.annotations.Test;

public class CreateListOfUsersUsingArrayTest extends BaseTest {

    @Test
    public void createListOfUsersUsingArray() {
        UserTestHelper userTestHelper = new UserTestHelper();
        userTestHelper.buildListOfUsersUsingArrayPayload();
        userTestHelper.postCreateListOfUsersUsingArray();
        userTestHelper.validateListOfUsersCreated();
    }

}
