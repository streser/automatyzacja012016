import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class streserSzkolenieTest extends seleniumBase {
    @Test
    public void shouldUserBeAbleToAddPublishAndDeletePost(){
        clickByLink("Posts");
        clickByLink("Add New");
        String title = uuid.toString() + "Piotr";
        insertTextIntoField("title",title);
        insertTextIntoField("content","ble");
        clickById("publish");
        clickByLink("View post");
        WebElement element = driver.findElement(By.className("entry-title"));
        assertEquals(element.getText(),title);
        driver.get("http://streser.nazwa.pl/szkolenie/wp-admin/");
        clickByLink("Posts");
            //element = driver.findElement(By.xpath("//tbody/tr/td[@title=title"));
        List<WebElement> allTr = driver.findElements(By.tagName("tr"));
        for (WebElement tr: allTr){
            if (tr.getText().contains(title)){
                WebElement checkbox = tr.findElement(By.tagName("input"));
                checkbox.click();
            }
        }
        Select dropdown = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
        dropdown.selectByVisibleText("Move to Trash");
        clickById("doaction2");
        assertEquals(driver.findElement(By.id("message")).getText(), "1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");
    }

}
