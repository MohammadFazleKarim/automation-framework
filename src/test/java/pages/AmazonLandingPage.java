package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AmazonLandingPage extends AmazonBasePage {

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement accountList;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cart;

    @FindBy(xpath = "//a[@data-nav-ref='nav_signin']")
    private WebElement signIn;

    public AmazonLoginPage hoverOnAccountListAndClickOnSignIn() throws InterruptedException {
        Thread.sleep(5000);
        getActions().moveToElement(this.accountList).build().perform();
        getActions().click(this.signIn).build().perform();
        return newPage(AmazonLoginPage.class, driver);
    }

    public boolean validatePageHasLoaded(){
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(this.accountList);
        elementList.add(this.cart);
        return validateElementsAreVisible(elementList);
    }

}
