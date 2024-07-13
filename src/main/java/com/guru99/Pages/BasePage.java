package com.guru99.Pages;

import commonLibs.impelimintation.ElementControl;
import org.openqa.selenium.WebDriver;

public class BasePage {


    WebDriver driver;
    public ElementControl elementControl;
    public BasePage(WebDriver driver) {
        //super();
        this.driver = driver;
        elementControl=new ElementControl(driver);
    }
}
