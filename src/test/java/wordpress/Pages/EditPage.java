package wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016-01-19.
 */
public class EditPage extends Page {
    public EditPage(WebDriver driver) {
        super(driver);
    }

    public void AddNewPost(String title) {
        WebElement postTextBox = FindElementById("title-prompt-text");
        InsertText(postTextBox, title);
        WebElement publishButton = FindElementById("publish");
        ClickElement(publishButton);

    }

    public FrontPage GoToEditPage() {

        driver.get("http://streser.nazwa.pl/szkolenie/wp-admin/edit.php");
        return new FrontPage(driver);

    }
}
