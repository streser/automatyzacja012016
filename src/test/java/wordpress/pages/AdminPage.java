package wordpress.pages;

import org.openqa.selenium.By;
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
        driver.get("http://streser.nazwa.pl/szkolenie/wp-admin/post-new.php");
        return new AddNewPostPage(driver);
    }

    public void goToPostListAndClickInTitle(String title){
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementByText(title));
    }

    public void editVisibility(){
        driver.findElement(By.className("edit-visibility")).click();
        wait(By.id("visibility-radio-private"));
        clickElement(findWebElementById("visibility-radio-private"));
        clickElement(findWebElementByText("OK"));
        clickElement(findWebElementById("publish"));
    }
}
