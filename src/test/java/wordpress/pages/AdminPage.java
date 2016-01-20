package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage extends Page{
    public AdminPage(WebDriver driver) {
        super(driver);


    }

    public void addPost(String title) {
        clickByLink("Posts");
        clickByLink("Add New");
        insertTextIntoField("title",title);
        insertTextIntoField("content","ble");
        clickById("publish");

    }
    public void viewCreatedPost() {
        clickByLink("View post");
    }

    public void openWebpage(String baseUrl) {
        driver.get(baseUrl + "/");
    }

    public void deletePost(String title) {
        clickByLink("Posts");
        clickCheckboxOfPost(title);
        clickSelectedFieldInForm("Move to Trash");
    }
    public void clickSelectedFieldInForm(String text) {
        Select dropdown = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
        dropdown.selectByVisibleText(text);
        clickById("doaction2");
    }

    public void clickCheckboxOfPost(String title) {
        List<WebElement> allTr = driver.findElements(By.tagName("tr"));
        for (WebElement tr: allTr){
            if (tr.getText().contains(title)){
                WebElement checkbox = tr.findElement(By.tagName("input"));
                checkbox.click();
            }
        }
    }
}
