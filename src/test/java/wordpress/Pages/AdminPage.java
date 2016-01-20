package wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2016-01-19.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public EditPage GoToAddNewPostPage(String title, String status, String visibility) {
        WebElement postLink = FindElementByLinkText("Posts");
        ClickElement(postLink);
        WebElement addPost = FindElementByLinkText("Add New");
        ClickElement(addPost);
        if (status != null) {
            WebElement statusEditLink = FindElementByClassName("edit-post-status");
            ClickElement(statusEditLink);
            WaitForElement(By.id("post_status"));
            Select dropdown = new Select(driver.findElement(By.id("post_status")));
            dropdown.selectByValue(status);
            WebElement btnOk1 = FindElementByClassName("save-post-status");
            ClickElement(btnOk1);
        }
        if (visibility != null) {

            WebElement visibilityEditLink = FindElementByClassName("edit-visibility");
            ClickElement(visibilityEditLink);
            WaitForElement(By.id("post-visibility-select"));
            WebElement privateOption = FindElementById(visibility);
            ClickElement(privateOption);
            WebElement btnOk1 = FindElementByClassName("save-post-visibility");
            ClickElement(btnOk1);
        }
        return new EditPage(driver);
    }

    public EditPage GoToAddNewPostPage(String title) {
        GoToAddNewPostPage(title, null, null);
        return new EditPage(driver);
    }
}
