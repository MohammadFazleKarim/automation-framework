package actions;

import pages.AmazonHomePage;
import pages.AmazonLandingPage;
import pages.AmazonLoginPage;

public class AmazonCustomerActions {

    public AmazonLoginPage buyerHoversOnAccountListAndClickOnSignIn(AmazonLandingPage landingPage) throws InterruptedException {
        return landingPage.hoverOnAccountListAndClickOnSignIn();
    }

    public AmazonHomePage buyerEntersCredentialsForLogin(AmazonLoginPage loginPage, String username, String password) throws InterruptedException {
        return loginPage.enterCredentialsForLogin(username, password);
    }


}
