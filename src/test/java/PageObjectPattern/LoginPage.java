package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class LoginPage extends Page{

    public String login = "admin";
    public String password = "password";

    public LoginPage(WebDriver driver){
        super(driver);
    }


    public MainPage LogIn()
    {
        driver.findElement(By.id("user_login")).sendKeys(login);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        //try {
        //    TimeUnit.SECONDS.sleep(10);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
       // }
        return new MainPage(driver);

    }



}
