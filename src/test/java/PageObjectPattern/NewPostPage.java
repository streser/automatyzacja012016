package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

/**
 * Created by Administrator on 2016-01-19.
 */
public class NewPostPage extends Page{

    private String xAllNewTests = "//a[text()='All Posts']";
    public static String  title;

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public NewPostPage AddPost(){
        title  = "MS"+UUID.randomUUID().toString();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("publish")).click();
        return this;
    }

    public MainPage ViewAllPost()
    {
        driver.findElement(By.xpath(xAllNewTests)).click();
        return new MainPage(driver);
    }
}
