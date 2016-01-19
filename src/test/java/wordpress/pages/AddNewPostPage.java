package wordpress.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class AddNewPostPage extends AdministratePage {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPost(String title) {
        writTextToElement(title, findWebElementById("title"));
        writTextToElement("Testowa wiadomość", findWebElementById("content"));
        clickElement(findWebElementById("publish"));
    }
}
