package com.guru99.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BasePage{



    @CacheLookup
    @FindBy(name="uid")
    private WebElement userid;

    @FindBy(name="password")
    private WebElement userpassword;
    @FindBy(name="btnLogin")
    private WebElement loginbtn;
    public Loginpage(WebDriver driver ) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    public void loginTpApplication(String username,String password) {
        elementControl.sendkeys(userid, username);
        elementControl.sendkeys(userpassword, password);
        elementControl.clickElement(loginbtn);
    }


}
