import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-01-19.
 */
public class SeleniumBase {
    protected WebDriver driver;
    protected String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://agileszkolenia.pl/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
