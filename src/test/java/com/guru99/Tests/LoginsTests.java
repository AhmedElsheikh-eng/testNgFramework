package com.guru99.Tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginsTests extends BaseTests{
    @Parameters({"username","password"})
    @Test
    public void verifyUserLoginWithCorrectCerdentials(String username,String password) {
//
        reportUtils.createTestCase("verify User LoginWithCorrectCerdentials");
        reportUtils.addTestLog(Status.INFO, "Performin Log");
        loginpage.loginTpApplication(username, password);
        String ActualTiltle=comnDriver.getTitle(),ExpectedTitle="Guru99 Bank Manager HomePage";
        reportUtils.addTestLog(Status.INFO, "Comparing Actual and Expected");
        Assert.assertEquals(ActualTiltle, ExpectedTitle);
    }
}
