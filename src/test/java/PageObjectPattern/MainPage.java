package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-01-19.
 */
public class MainPage extends Page{

    private WebDriverWait wait;
    private String xPostMenu = "//div[text()='Posts']";
    private String xAddNew = "//a[text()='Add New']";
    private String xPostElement = "//a[text()='%s']";
    private String xCheckBoxToDelete = "//a[text()='%s']/ancestor::tr/th/input";
    private String xTrashToDelete = "//a[text()='%s']/ancestor::tr//a[text()='Trash']";

    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,10);
    }

    public NewPostPage AddNew() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPostMenu))).click();
        driver.findElement(By.xpath(xAddNew)).click();
        return new NewPostPage(driver);
    }

    public MainPage DeletePost(){

        String title = NewPostPage.title;
        driver.findElement(By.xpath(String.format(xCheckBoxToDelete,title))).click();
        driver.findElement(By.xpath(String.format(xTrashToDelete,title))).click();
        return this;
    }

    public boolean isPostPresent(){
        try {
            return driver.findElement(By.xpath(String.format(xPostElement,NewPostPage.title))).getText().equals(NewPostPage.title);

        }
            catch(NoSuchElementException e){
            return false;
        }
    }

}