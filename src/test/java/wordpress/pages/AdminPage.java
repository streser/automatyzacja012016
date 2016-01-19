package wordpress.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class AdminPage extends AdministratePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened(){
        return true;
    }

    public AddNewPostPage goToAddNewPostPage() {
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementByText("Add New"));
        return new AddNewPostPage(driver);
    }
}
