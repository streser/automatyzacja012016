package wordpress.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public abstract class Page {

    WebDriver driver;

    public Page(WebDriver driver) {

        this.driver = driver;

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

    public void openListOfPosts() {
        String link = "http://streser.nazwa.pl/szkolenie/wp-admin/";
        driver.get(link + "/");
        driver.findElement(By.className("wp-menu-name")).click();
    }

    public void waitForElement(String id){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }
}
