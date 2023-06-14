package runner;

import base.Base;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
//        tags = "@Regression",
        plugin = { "html:target/cucumber-reports/report.html" }
)

public class Runner {
    @AfterClass
    public static void writeExtentReport() {
        String projectPath = System.getProperty("user.dir");
        Reporter.loadXMLConfig(new File(Base.getReportConfigPath(projectPath + "/extent-config.xml")));
    }
}
