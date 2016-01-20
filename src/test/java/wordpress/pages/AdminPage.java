package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class AdminPage extends Page{

    public String postTitle = UUID.randomUUID().toString();
    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void addNewPost(String status) {
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.className("page-title-action")).click();
        driver.findElement(By.id("title")).sendKeys(postTitle);
        driver.findElement(By.className("edit-post-status")).click();
        waitForElement("post_status");
        Select select = new Select(driver.findElement(By.id("post_status")));
        select.selectByVisibleText(status);
        driver.findElement(By.className("save-post-status")).click();
        driver.findElement(By.className("edit-visibility")).click();
        waitForElement("visibility-radio-private");
        driver.findElement(By.id("visibility-radio-" + Visibility.PRIVATE)).click();
        driver.findElement(By.className("save-post-visibility")).click();
        driver.findElement(By.id("publish")).click();
    }

    public void findPost() {
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.linkText(postTitle)).click();
        assertEquals(driver.findElement(By.id("post-status-display")).getText(), "Privately Published");
        assertEquals(driver.findElement(By.id("post-visibility-display")).getText(), "Private");
    }


}
