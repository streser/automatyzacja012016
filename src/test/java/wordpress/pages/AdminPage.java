package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

    public void addPostWithParameters(String title) {
        clickByLink("Posts");
        clickByLink("Add New");
        insertTextIntoField("title",title);
        insertTextIntoField("content","ble");
        driver.findElement(By.className("edit-post-status")).click();
        waitForElement("post-status-select");
        clickSelectedFieldInForm2("Pending Review");
        driver.findElement(By.className("edit-visibility")).click();
        waitForElement("post-visibility-select");
        driver.findElement(By.id("visibility-radio-private")).click();
        driver.findElement(By.className("save-post-visibility")).click();
        clickById("publish");
    }

    public void viewCreatedPost() {
        clickByLink("View post");
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

    protected void clickSelectedFieldInForm2(String text) {
        Select dropdown = new Select(driver.findElement(By.id("post_status")));
        dropdown.selectByVisibleText(text);
        driver.findElement(By.className("save-post-status")).click();
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
    public void assertIfDisplayedMessageHasText(String actual) {
        assertEquals(driver.findElement(By.id("message")).getText(), actual);
    }

    public void assertIfDisplayedPostHasName(String actual) {
        assertEquals(driver.findElement(By.className("entry-title")).getText(), actual);
    }

    public void assertIfDisplayedPostHasNamePrivat(String actual) {
        assertEquals(driver.findElement(By.className("entry-title")).getText(), actual);
    }
}
