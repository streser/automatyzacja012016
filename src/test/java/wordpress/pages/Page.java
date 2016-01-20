package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-01-19.
 */
public abstract class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
    }

    public boolean isOpened() {
        return true;
    }


    public BlogPage goToBlog() {
        driver.get("http://streser.nazwa.pl/szkolenie/");
        return new BlogPage(driver);
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

    public void wait(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
