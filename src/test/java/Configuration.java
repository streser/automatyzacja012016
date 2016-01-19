import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016-01-19.
 */
public class Configuration {

    public WebDriver driver;
    public String baseUrl = "http://streser.nazwa.pl/szkolenie/wp-login.php";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    public void OpenUrl(String url)
    {
        driver.get(url);
    }

    public void OpenLink(String linkToOpen)
    {
        driver.findElement(By.linkText(linkToOpen)).click();
    }

    public void FindElement(String id)
    {
        driver.findElement(By.id(id)).click();
    }

    public void AssertThatTextEqualsValue(String textToCheck)
    {
        assertEquals(textToCheck, driver.findElement(By.linkText(textToCheck)).getText());
    }
}
