package PageObjectPattern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public abstract class Page {
    public WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;

    }
}