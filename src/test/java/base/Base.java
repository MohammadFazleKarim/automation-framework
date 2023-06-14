package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Base extends DriverSetup {

	protected static Actions getActions() {
		return action = new Actions(driver);
	}

	protected static void navigateToApplication(String url) {
		driver.navigate().to(url);
	}

	protected static String getTextOfElement(WebElement element){
		return element.getText();
	}

	protected static boolean elementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	protected static void selectFromDropdown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	protected static <T> T newPage(Class<T> testClass, WebDriver driver) {
		return PageFactory.initElements(driver, testClass);
	}

	public static String getReportConfigPath(String reportConfigPath){
		if(reportConfigPath!= null) {
			return reportConfigPath;
		}
		else {
			throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}

}
