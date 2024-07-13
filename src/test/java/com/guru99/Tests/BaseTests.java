package com.guru99.Tests;

import com.guru99.Pages.Loginpage;
import commonLibs.Utils.ConfigUtils;
import commonLibs.Utils.ReportUtils;
import commonLibs.Utils.ScreenshotUtils;
import commonLibs.impelimintation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import java.util.Properties;

public class BaseTests {
    WebDriver driver;
    CommonDriver comnDriver;
    String currentWorkingDirectory;
    Properties configProperty;
    String browserType;
    String url="http://demo.guru99.com/v4";
    Loginpage loginpage;
    String configFileName;
    String reportFileName;
    ReportUtils reportUtils;
    ScreenshotUtils screenshot;
    @BeforeSuite
    public void preSetup() throws Exception{
        currentWorkingDirectory=System.getProperty("user.dir");
        configFileName=currentWorkingDirectory+"/config/config.properties";
        configProperty= ConfigUtils.readProperties(configFileName);


        reportFileName=currentWorkingDirectory+"/reports/guru99Test.html";
        reportUtils=new ReportUtils(reportFileName);
    }
    @BeforeClass
    public void setup() throws Exception{
        url=configProperty.getProperty("baseUrl");
        browserType=configProperty.getProperty("chrome");
        comnDriver=new CommonDriver("chrome");
        driver=comnDriver.getDriver();
        loginpage=new Loginpage(driver);
        screenshot=new ScreenshotUtils(driver);
        comnDriver.navigateToUrl(url);
    }
    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {
        String testcaseName=result.getName();
        long executionTime=System.currentTimeMillis();
        String screenshotFilename=currentWorkingDirectory+"/screenshots/"+testcaseName+executionTime+".jpg";
        if(result.getStatus()==ITestResult.FAILURE) {
            reportUtils.addTestLog(Status.FAIL, "One or More steps are Failied");
            screenshot.captureAndSaveScreenshot(screenshotFilename);
            reportUtils.attachScreenshotToReport(screenshotFilename);
        }
    }
    @AfterClass
    public void tearDown() {
        comnDriver.closeAllBrowser();
    }
    @AfterSuite
    public void postTearDown() {
        reportUtils.flushReport();
    }
}
