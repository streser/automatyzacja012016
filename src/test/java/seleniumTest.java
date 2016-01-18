import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumTest {
    private WebDriver driver;
    private String baseUrl; 
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://agileszkolenia.pl/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumTestIDE() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Szkolenia")).click();
        driver.findElement(By.linkText("Szkolenia")).click();
        assertEquals("Szkolenia", driver.findElement(By.cssSelector("h1.entry-title")).getText());
        driver.findElement(By.id("mt-dla-testerow")).click();
        try {
            assertEquals("Automatyzacja Testów", driver.findElement(By.linkText("Automatyzacja Testów")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Coaching")).click();
        try {
            assertEquals("Agile Coaching", driver.findElement(By.cssSelector("h1.entry-title")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testSeleniumTestIDE2() throws Exception {
        driver.get(baseUrl + "/");
        //driver.findElement(By.linkText("Coaching")).click();
        driver.findElement(By.linkText("Szkolenia")).click();
        driver.findElement(By.id("mt-dla-organizacji")).click();
        try {
            assertEquals("Leading SAFe", driver.findElement(By.linkText("Leading SAFe")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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


