package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class AdminPage extends Page{

    public String postTitle = UUID.randomUUID().toString();
    public AdminPage(WebDriver driver){
        super(driver);
    }
    public void addNewPost() {
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.className("page-title-action")).click();
        driver.findElement(By.id("title")).sendKeys(postTitle);
        driver.findElement(By.id("publish")).click();
    }
}
