package wordpress.pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-01-19.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("http://streser.nazwa.pl/szkolenie/wp-login.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public AdminPage correctLogin() {
        writTextToElement("admin", findWebElementById("user_login"));
        writTextToElement("password", findWebElementById("user_pass"));
        clickElement(findWebElementById("wp-submit"));
        return new AdminPage(driver);
    }
}