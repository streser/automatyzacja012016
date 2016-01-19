package wordpress;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-01-19.
 */
public class BaseTest {

    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();


    }

    @After
    public void tearDown() throws Exception {

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebElement findWebElementByText(String text){
        return driver.findElement(By.linkText(text));
    }

    public WebElement findWebElementById(String text){
        return driver.findElement(By.id(text));
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void writTextToElement(String text, WebElement element){
        element.sendKeys(text);
    }

    public void goToPage(String page){
        driver.get(page);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void selectSelectByValue(String id, String valueToSelect){
        Select select = new Select(findWebElementById(id));
        select.selectByValue(valueToSelect);
    }
}
