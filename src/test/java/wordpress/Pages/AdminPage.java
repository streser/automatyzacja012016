package wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016-01-19.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public EditPage GoToAddNewPostPage(String title) {
        WebElement postLink = FindElementByLinkText("Posts");
        ClickElement(postLink);
        WebElement addPost = FindElementByLinkText("Add New");
        ClickElement(addPost);
        return  new EditPage(driver);
    }
}
