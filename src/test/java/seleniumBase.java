import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
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
        openWebpage(baseUrl);
        loginToWebpage();
        clickById("wp-submit");
    }

    protected void openWebpage(String baseUrl) {
        driver.get(baseUrl + "/");
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

    protected void clickSelectedFieldInForm(String text) {
        Select dropdown = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
        dropdown.selectByVisibleText(text);
        clickById("doaction2");
    }

    protected void clickCheckboxOfPost(String title) {
        List<WebElement> allTr = driver.findElements(By.tagName("tr"));
        for (WebElement tr: allTr){
            if (tr.getText().contains(title)){
                WebElement checkbox = tr.findElement(By.tagName("input"));
                checkbox.click();
            }
        }
    }

    protected void assertIfDisplayedMessageHasText(String actual) {
        assertEquals(driver.findElement(By.id("message")).getText(), actual);
    }

    protected void assertIfDisplayedPostHasName(String actual) {
        assertEquals(driver.findElement(By.className("entry-title")).getText(), actual);
    }
}
