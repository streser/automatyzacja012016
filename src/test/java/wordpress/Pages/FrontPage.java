package wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016-01-19.
 */
public class FrontPage extends Page {
    public FrontPage(WebDriver driver) {
        super(driver);

    }

    public boolean isPostDisplayed(String title) {
        WebElement recentlyAddeedPost = FindElementByLinkText(title);
        return title.equals(recentlyAddeedPost.getText());
    }

    public boolean isPostPrivate(String title) {
        WebElement postStatus = driver.findElement(By.xpath("//a[text()='" + title +"']/following-sibling::span[1]"));
        String status = "Private";
        return status.equals(postStatus.getText());
    }
}
