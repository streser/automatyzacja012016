package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class BlogPage extends Page {
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostVisible(String title) {
        try {
            return title.equals(driver.findElement(By.linkText(title)).getText());
        }catch (Exception e){
            return false;
        }
    }

    public AdminPage goToAdminPage(){
        driver.get("http://streser.nazwa.pl/szkolenie/wp-admin/");
        return new AdminPage(driver);
    }
}
