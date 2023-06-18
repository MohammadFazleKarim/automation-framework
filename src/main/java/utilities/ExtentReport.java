package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports setupReport() {
		String projectPath = System.getProperty("user.dir");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(projectPath + "/target/reports/extent-report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setOfflineMode(true);
		sparkReporter.config().setDocumentTitle("Extent Report");
		sparkReporter.config().setReportName("Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zzz')'");
		sparkReporter.config().setEncoding("UTF-8");

		return extent;
	}

}
