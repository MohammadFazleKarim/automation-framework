package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AmazonLoginPage extends AmazonBasePage {

    @FindBy(xpath = "//h1")
    private WebElement signInText;

    @FindBy(xpath = "//label[@for='ap_email']")
    private WebElement mobilePhoneNumberOrEmailLabel;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='auth-error-message-box']//span")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@id='auth-email-missing-alert']//div[@class='a-alert-content']")
    private WebElement alertContentForMissingEmail;

    @FindBy(xpath = "//div[@id='auth-password-missing-alert']//div[@class='a-alert-content']")
    private WebElement alertContentForMissingPassword;

    public AmazonHomePage enterCredentialsForLogin(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        getActions().sendKeys(this.usernameTextBox, username).build().perform();
        Thread.sleep(5000);
        getActions().click(this.continueButton).build().perform();
        Thread.sleep(5000);
        getActions().sendKeys(this.passwordTextBox, password).build().perform();
        Thread.sleep(5000);
        getActions().click(this.signInButton).build().perform();
        Thread.sleep(5000);
        return newPage(AmazonHomePage.class, driver);
    }

    public boolean validatePageHasLoaded(){
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(this.signInText);
        elementList.add(this.mobilePhoneNumberOrEmailLabel);
        elementList.add(this.usernameTextBox);
        elementList.add(this.continueButton);
        return validateElementsAreVisible(elementList);
    }

}
