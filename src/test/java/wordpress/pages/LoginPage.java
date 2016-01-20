package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wordpress.pages.Page;

import java.util.UUID;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://streser.nazwa.pl/szkolenie/");
    }

    public void correctLogin(String login, String pwd) {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("user_login")).sendKeys(login);
        driver.findElement(By.id("user_pass")).sendKeys(pwd);
        clickById("wp-submit");
    }
}
