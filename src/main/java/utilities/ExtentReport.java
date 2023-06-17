package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	
	public static ExtentReports setupReport() {
		String path = System.getProperty("user.dir");
		sparkReporter = new ExtentSparkReporter(path + "\\reportsSection\\ExtentReport.html");
		extent = new ExtentReports();
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
