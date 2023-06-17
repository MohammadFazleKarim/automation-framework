package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import actions.AmazonCustomerActions;
import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AmazonHomePage;
import pages.AmazonLandingPage;
import pages.AmazonLoginPage;

public class AmazonLoginTest extends Base {

	AmazonLandingPage landingPage = null;
	AmazonLoginPage loginPage = null;
	AmazonHomePage homePage = null;
	AmazonCustomerActions customerActions = new AmazonCustomerActions();

	@Given("Customer is in Amazon Landing page")
	public void customer_is_in_amazon_landing_page() {
		String url = Hook.configProperties.getProperty("base_url");
		navigateToApplication(url);
	}

	@And("Validate Amazon landing page has been loaded")
	public void validate_amazon_landing_page_has_been_loaded(){
		landingPage = newPage(AmazonLandingPage.class, driver);
		assertTrue(landingPage.validatePageHasLoaded());
	}

	@Then("Hover on AccountsList and click on sign in")
	public void hover_on_accountsList_and_click_on_sign_in() throws InterruptedException {
		loginPage = customerActions.buyerHoversOnAccountListAndClickOnSignIn(landingPage);
	}

	@And("Validate Amazon Login page has been loaded")
	public void validate_amazon_login_page_has_been_loaded(){
		assertTrue(loginPage.validatePageHasLoaded());
	}

	@When("Customer is in Amazon Login page, enter <email> and <password> for login")
	public void customer_is_in_amazon_login_page_enter_email_and_password_for_login(DataTable dataTable) throws InterruptedException {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		homePage = customerActions.buyerEntersCredentialsForLogin(loginPage, data.get("email"), data.get("password"));
	}

	@Then("Validate Amazon home page has been loaded")
	public void validate_amazon_home_page_has_been_loaded(){
		assertTrue(homePage.validatePageHasLoaded());
	}

}
