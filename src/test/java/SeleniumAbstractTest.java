import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class SeleniumAbstractTest {

    public static String baseUrl;
    public static WebDriver driver;
    public static StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://streser.nazwa.pl/szkolenie/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).sendKeys("password");
        driver.findElement(By.id("wp-submit")).click();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
