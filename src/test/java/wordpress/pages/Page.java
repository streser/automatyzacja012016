package wordpress.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public abstract class Page {

    WebDriver driver;

    public Page(WebDriver driver) {

        this.driver = driver;

    }


    protected void clickByLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }


    protected void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    protected void insertTextIntoField(String field, String text) {
        driver.findElement(By.id(field)).sendKeys(text);
    }
    public void assertIfDisplayedMessageHasText(String actual) {
        assertEquals(driver.findElement(By.id("message")).getText(), actual);
    }

    public void assertIfDisplayedPostHasName(String actual) {
        assertEquals(driver.findElement(By.className("entry-title")).getText(), actual);
    }
}
