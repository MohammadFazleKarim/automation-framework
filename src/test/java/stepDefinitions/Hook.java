package stepDefinitions;

import java.io.IOException;

import base.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.EmailUtils;

public class Hook extends DriverSetup {

	@Before
	public void setUp() throws IOException {
		initializeProperties();
		initDriver();
	}

	@After
	public void tearDown() {
		quitDriver();
		EmailUtils.sendReportToMail("cucumber-report.html");
	}

	@AfterStep
	public void endstep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}
}
