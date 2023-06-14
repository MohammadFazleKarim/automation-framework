package stepDefinitions;

import java.io.IOException;

import base.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends DriverSetup {

	@Before
	public void setUp() throws IOException {
		initDriver();
	}

	@After
	public void tearDown() {
		quitDriver();
	}

	@AfterStep
	public void endstep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}
}
