package wordpress.Pages;

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
}
