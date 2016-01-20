package wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016-01-19.
 */
public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Open() {
        driver.get("http://streser.nazwa.pl/szkolenie/");
    }

    public AdminPage CorrectLogin(String login, String password) {
        WebElement loginLink = FindElementByLinkText("Log in");
        ClickElement(loginLink);
        WebElement usernameTextbox = FindElementById("user_login");
        InsertText(usernameTextbox, login);
        WebElement passwordTextbox = FindElementById("user_pass");
        InsertText(passwordTextbox, password);
        WebElement loginBtn = FindElementById("wp-submit");
        ClickElement(loginBtn);
        return new AdminPage(driver);
    }
}
