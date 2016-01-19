import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


public class seleniumBase {

    protected WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;
    public UUID uuid = UUID.randomUUID();

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseUrl = "http://streser.nazwa.pl/szkolenie/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        loginToWebpage();
        clickById("wp-submit");
    }

    @After
    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected void loginToWebpage(){
        clickByLink("Log in");
        insertTextIntoField("user_login","admin");
        insertTextIntoField("user_pass","password");
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
