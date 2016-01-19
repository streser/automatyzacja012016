import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class LoginPage {

    private WebDriver driver;
    public String login = "admin";
    public String password = "password";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public MainPage LogIn()
    {
        driver.findElement(By.id("user_login")).sendKeys(login);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        return new MainPage(driver);

    }



}
