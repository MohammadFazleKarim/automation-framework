package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ExcelReader;
import utilities.ExtentReport;

import java.lang.reflect.Method;

public class BaseTest {

    public static ExtentReports extent;
    public static ExcelReader testDataExcel;
    public static ExtentTest report;
    public static Throwable throwable;

    @BeforeSuite
    public void setup() {
        System.out.println("Before Suite execution");
        DriverSetup.initializeProperties();
//        extent = ExtentReport.setupReport();
//        testDataExcel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/test-data/TestData.xlsx","sheet1");
    }

    @BeforeMethod
    public static void createTest(Method method) {
//        System.out.println("Before Method execution");
//        String currentMethod = method.getName();
//        report = extent.createTest(currentMethod);
//        report.log(Status.INFO, "Starting the test : " + report.getStatus());
//        report.assignCategory("P1");
    }

    @AfterMethod
    public static void flushReport(Method method) {
//        System.out.println("After Method execution");
//        String currentMethod = method.getName();
//        if(report.getStatus().equals(Status.PASS)) {
//            report.log(Status.PASS, currentMethod + " case passed");
//        }
//        else if (report.getStatus().equals(Status.SKIP)) {
//            report.log(Status.SKIP, currentMethod + " case skipped");
//        }
//        else if (report.getStatus().equals(Status.FAIL)) {
////			report.log(Status.FAIL, currentMethod + " case failed");
//            report.log(Status.FAIL, throwable.getMessage());
//        }
    }

    @AfterSuite
    public void quitDriverAndSendReportToMail() {
//        extent.flush();
//		quitDriver();
//		EmailUtils.sendMail();
    }

}
