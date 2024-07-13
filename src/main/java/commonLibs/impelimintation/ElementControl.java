package commonLibs.impelimintation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {

    WebDriver driver;


    public ElementControl(WebDriver driver) {
        super();
        this.driver = driver;
    }
    public void clickElement(WebElement element) {
        element.click();

    }
    public void clear(WebElement element) {
        element.clear();

    }


    public void sendkeys(WebElement element,String text) {
        element.sendKeys(text);

    }
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String gettextFromAlert() {
        return driver.switchTo().alert().getText();
    }
    public void selectViaVisableText(WebElement element,String text) {
        Select selDropdown=new Select(element);
        selDropdown.selectByVisibleText(text);


    }

}
