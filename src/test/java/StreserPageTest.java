import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StreserPageTest extends SeleniumAbstractTest{

    public String postTitle = UUID.randomUUID().toString();

    @Test
    public void shouldRemoveNewPost() throws InterruptedException {
        goToPostCreationPage();

        createNewPost(postTitle);

        findPostToDelete(postTitle);

        deletePost(postTitle);
    }

    private void deletePost(String postTitle) {
        Select select = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
        select.selectByVisibleText("Move to Trash");
        driver.findElement(By.id("doaction2")).click();
        assertFalse(driver.getPageSource().contains(postTitle));
    }

    private void findPostToDelete(String postTitle) {
        driver.findElement(By.linkText("Posts")).click();
        assertEquals(driver.findElement(By.linkText(postTitle)).getText(), postTitle);
        String myXpath = String.format("//td[.//a/text()=\"%s\"]/ancestor::tr[1]//th/input", postTitle);
        driver.findElement(By.xpath(myXpath)).click();
    }

    private void goToPostCreationPage() {
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.className("page-title-action")).click();
    }

    private void createNewPost(String postTitle) {
        driver.findElement(By.id("title")).sendKeys(postTitle);
        driver.findElement(By.id("publish")).click();
    }
}
