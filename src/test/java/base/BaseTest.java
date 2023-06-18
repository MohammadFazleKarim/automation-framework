package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.EmailUtils;
import utilities.ExcelReader;
import utilities.ExtentReport;

import java.lang.reflect.Method;

public class BaseTest {

    public static ExtentReports extent;
    public static ExcelReader testDataExcel;
    public ExtentTest report;

    @BeforeSuite
    public void setup() {
        System.out.println("Before Suite execution");
        DriverSetup.initializeProperties();
        extent = ExtentReport.setupReport();
//        testDataExcel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/test-data/TestData.xlsx","sheet1");
    }

    @BeforeMethod
    public void createTest(Method method) {
        System.out.println("Before Method execution");
        String currentMethod = method.getName();
        report = extent.createTest(currentMethod);
        report.log(Status.INFO, "Starting the test");
        report.assignCategory("P1");
    }

    @AfterMethod
    public void getResult(Method method, ITestResult testResult) {
        System.out.println("After Method execution");
        String testName = method.getName();

        int status = testResult.getStatus();
        if (status == ITestResult.SUCCESS) {
            report.log(Status.PASS, testName + " executed with success");
        }
        else if (status == ITestResult.SKIP) {
            report.log(Status.SKIP, testResult.getThrowable());
        }
        else if (status == ITestResult.FAILURE) {
            report.log(Status.FAIL, testResult.getThrowable());
        }
    }

    @AfterSuite
    public void flushReportAndSendReportToMail() {
        extent.flush();
		EmailUtils.sendReportToMail("extent-report.html");
    }

}
