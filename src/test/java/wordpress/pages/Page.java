package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }
    public enum Visibility{
        PUBLIC,
        PRIVATE,
        PASSWORD;

        @Override
        public String toString() {
            String result = super.toString();
            return result.toLowerCase();
        }
    }
    public void waitForElement(String element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
    }
}
