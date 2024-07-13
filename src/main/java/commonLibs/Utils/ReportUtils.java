package commonLibs.Utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ReportUtils {

    ExtentHtmlReporter htmlreporter;
    ExtentReports extentreports;
    ExtentTest extenttest;
    public ReportUtils(String htmlReportFilename) {
        htmlReportFilename=htmlReportFilename.trim();
        htmlreporter=new ExtentHtmlReporter(htmlReportFilename);
        extentreports=new ExtentReports();
        extentreports.attachReporter(htmlreporter);


    }
    public void createTestCase(String testName) {

        extenttest=extentreports.createTest(testName);
    }
    public void addTestLog(Status status, String comment) {
        extenttest.log(status, comment);
    }
    public void attachScreenshotToReport(String fileName) throws Exception {

        extenttest.addScreenCaptureFromPath(fileName);
    }
    public void flushReport() {
        extentreports.flush();
    }
}
