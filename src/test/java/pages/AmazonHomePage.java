package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AmazonHomePage extends AmazonBasePage {

    @FindBy(xpath = "//a[@data-nav-role='signin']")
    private WebElement accountList;

    @FindBy(xpath = "//a[@id='nav-item-signout']")
    private WebElement signOut;

    public boolean validatePageHasLoaded(){
        getActions().moveToElement(this.accountList).build().perform();
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(this.accountList);
        elementList.add(this.signOut);
        return validateElementsAreVisible(elementList);
    }

}
