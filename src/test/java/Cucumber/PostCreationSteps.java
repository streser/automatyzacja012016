package Cucumber;

import PageObjectPattern.LoginPage;
import PageObjectPattern.MainPage;
import PageObjectPattern.NewPostPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 2016-01-20.
 */
public class PostCreationSteps {


    public WebDriver driver;
    public String baseUrl = "http://streser.nazwa.pl/szkolenie/wp-login.php";

    public void OpenUrl(String url)
    {
        driver.get(url);
    }
    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //private WebDriver driver;
    private NewPostPage newPostPage;
    private MainPage mainPage;

    @Given("^user is logged in$")
    public void user_is_logged_in() {

        OpenUrl(baseUrl);
        LoginPage login = new LoginPage(driver);
        mainPage = login.LogIn();
    }


    @When("^User adds new post with title and some content$")
    public void user_adds_new_post_with_title_and_some_content(){
        newPostPage = mainPage.AddNew();
        mainPage = newPostPage.AddPost().Publish().ViewAllPost();

    }

    @Then("^by default it should be visible on the blog$")
    public void by_default_it_should_be_visible_on_the_blog(){
        Assert.assertTrue(mainPage.isPostPresent());
    }

    @Given("^user is logged in and is editing the post$")
    public void user_is_logged_in_and_is_editing_the_post() {

        OpenUrl(baseUrl);
        LoginPage login = new LoginPage(driver);
        mainPage = login.LogIn();
        newPostPage = mainPage.AddNew();
    }


    @When("^user sets Private Visibility and Pending Status for the post$")
    public void user_sets_Private_Visibility_and_Pending_Status_for_the_post() {
        newPostPage.AddPost().SetPostAttributes("Pending Review","Private");
        mainPage = newPostPage.Publish().ViewAllPost();

    }

    @Then("^by defsult post should not be visible$")
    public void by_defsult_post_should_not_be_visible(){
        //Assert.assertFalse(mainPage.isPostPresent());
    }
}