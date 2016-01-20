package cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;

import java.util.UUID;

public class AddPostTest {
    private WebDriver driver;
    private LoginPage lp;
    private AdminPage ap;
    String title = UUID.randomUUID().toString();

    @Given("^user is logged in$")
    public void user_is_logged_in() {
        driver = new FirefoxDriver();
        LoginPage lp = new LoginPage(driver);
        lp.open();
        ap = lp.correctLogin("admin", "password");
    }

    @When("^user adds simple post$")
    public void user_adds_simple_post() {
        ap.addPost(title + " Piotr");
    }

    @Then("^added post should be visible in blog page$")
    public void added_post_should_be_visible_in_blog_page() {
        ap.assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");
        driver.quit();
    }

//    @Given("^user adds new post$")
//    public void user_adds_new_post() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^user changes visibility to privat$")
//    public void user_changes_visibility_to_privat() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^after adding post should be not visible to other users$")
//    public void after_adding_post_should_be_not_visible_to_other_users() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

}
