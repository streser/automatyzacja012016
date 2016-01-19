
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


import java.util.UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StreserPageTest extends SeleniumAbstractTest{

    public String title = UUID.randomUUID().toString();

    @Test
    public void shouldAddNewPost() throws InterruptedException {
        logIn();

        driver.findElement(By.linkText("Posts")).click();
        assertEquals(driver.findElement(By.linkText(title)).getText(), title);


        String myXpath = String.format("//td[.//a/text()=\"%s\"]/ancestor::tr[1]//th/input", title);
        driver.findElement(By.xpath(myXpath)).click();

        Select select = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
        select.selectByVisibleText("Move to Trash");
        driver.findElement(By.id("doaction2")).click();
        assertFalse(driver.getPageSource().contains(title));

    }

    private void logIn() {
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.className("page-title-action")).click();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("publish")).click();
    }

//    @Test
//    public void isNewPostAvailable(){
//        driver.findElement(By.linkText("Posts")).click();
//        assertEquals(driver.findElement(By.linkText(title)).getText(), title);
//    }
//
//    @Test
//    public void isMyPostRemoved() throws InterruptedException {
//        String myXpath = "//tbody/tr/th/label[text()='%s']/following-sibling::input[1]".format(title);
//        driver.findElement(By.xpath(myXpath)).click();
//        Thread.sleep(5000);
//    }
}
