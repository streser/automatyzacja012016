package wordpress.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void Open() {
        driver.get("http://streser.nazwa.pl/szkolenie/");
    }

    public AdminPage correctLogin() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).sendKeys("password");
        driver.findElement(By.id("wp-submit")).click();
        return new AdminPage(driver);
    }
}
