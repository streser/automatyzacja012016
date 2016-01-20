package cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import wordpress.pages.AddNewPostPage;
import wordpress.pages.AdminPage;
import wordpress.pages.BlogPage;
import wordpress.pages.LoginPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-01-20.
 */
public class PostCreationSteps {
    WebDriver driver;
    String title = null;
    LoginPage lp;
    AdminPage ap;
    BlogPage bp;
    AddNewPostPage anpp;

    @Given("^user is logged$")
    public void user_is_logged() throws Throwable {
        if(title==null) {
            title = UUID.randomUUID().toString();
        }
        driver = new FirefoxDriver();
        LoginPage lp = new LoginPage(driver);
        lp.open();
        ap = lp.correctLogin();
    }

    @When("^he adds new post with totle and simple content$")
    public void he_adds_new_post_with_totle_and_simple_content() throws Throwable {
        anpp = ap.goToAddNewPostPage();
        anpp.addNewPost(title);

    }

    @Then("^by default it should be visible on the blog$")
    public void by_default_it_should_be_visible_on_the_blog() throws Throwable {
        bp = anpp.goToBlog();
        assertTrue(bp.isPostVisible(title));
    }

    @When("^he delete post with selected title$")
    public void he_delete_post_with_selected_title() throws Throwable {
        goToPage("http://streser.nazwa.pl/szkolenie/wp-admin");
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementById(getCheckBoxId(title)));
        selectSelectByValue("bulk-action-selector-bottom", "trash");
        clickElement(findWebElementById("doaction2"));
    }

    @Then("^by default it shouldn't be visible on the blog$")
    public void by_default_it_shouldn_t_be_visible_on_the_blog() throws Throwable {
        bp = ap.goToBlog();
        assertFalse(bp.isPostVisible(title));
    }

    public void goToPage(String page){
        driver.get(page);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getCheckBoxId(String title){
        WebElement element = findWebElementByText(title);
        String link = element.getAttribute("href");
        link = link.substring((link.indexOf("post=")+5));
        String id = "";
        for(Character s: link.toCharArray()){
            if(s.toString().equals("&")) break;
            id += s.toString();
        }
        return "cb-select-"+id;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void writTextToElement(String text, WebElement element){
        element.sendKeys(text);
    }

    public WebElement findWebElementByText(String text){
        return driver.findElement(By.linkText(text));
    }

    public WebElement findWebElementById(String text){
        return driver.findElement(By.id(text));
    }

    public void selectSelectByValue(String id, String valueToSelect){
        Select select = new Select(findWebElementById(id));
        select.selectByValue(valueToSelect);
    }
}
