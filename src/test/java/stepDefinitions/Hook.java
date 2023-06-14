package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends Base {

	public static FileInputStream fileInputStream;
	public static Properties configProperties;

	@Before
	public void setUp() throws IOException {
		String projectPath = System.getProperty("user.dir");
		fileInputStream = new FileInputStream(projectPath + "/src/test/resources/properties/Configuration.properties");
		configProperties = new Properties();
		configProperties.load(fileInputStream);

		if(configProperties.getProperty("browser").contains("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		else if(configProperties.getProperty("browser").contains("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--remote-allow-origins=*");
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		else if(configProperties.getProperty("browser").contains("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

	}

	@After
	public void tearDown() {
		// driver.close();
	}

	@AfterStep
	public void endstep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}
}
