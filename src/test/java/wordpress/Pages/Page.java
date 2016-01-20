package wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-01-19.
 */
public class Page {
    protected final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement FindElementById(String id) {
        return driver.findElement(By.id(id));
    }

    protected void ClickElement(WebElement webElement) {
        webElement.click();
    }

    protected WebElement FindElementByLinkText(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    protected WebElement FindElementByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    protected void InsertText(WebElement usernameTextbox, String text) {
        usernameTextbox.sendKeys(text);
    }

    public void WaitForElement(By by) {
        WebDriverWait element = new WebDriverWait(driver, 10);
        element.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
}
