import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://agileszkolenia.pl/szkolenia/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //@Test
    public void testSeleniumTest() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Konsulting")).click();
        assertEquals("Konsulting metod Agile (Scrum, Kanban, SAFe), procesy IT", driver.getTitle());
        driver.findElement(By.linkText("Szkolenia")).click();
        assertEquals("Szkolenia Agile - Code Sprinters", driver.getTitle());
        driver.findElement(By.linkText("Coaching")).click();
        assertEquals("Agile Coaching - Code Sprinters", driver.getTitle());
    }

    @Test
    public void konsultingTest() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("mt-dla-organizacji")).click();
        assertTrue(driver.findElement(By.linkText("Leading SAFe")).isDisplayed());
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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

