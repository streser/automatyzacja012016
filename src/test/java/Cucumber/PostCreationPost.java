package Cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;
import wordpress.pages.Page;

import java.util.concurrent.TimeUnit;

public class PostCreationPost {

    public static WebDriver driver;
    public static String baseUrl;
    public AdminPage adminPage;

    @Before
    public void setUp(){
        //driver = new FirefoxDriver();
        driver = new HtmlUnitDriver();
        baseUrl = "http://streser.nazwa.pl/szkolenie/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^user is logged in$")
    public void user_is_logged_in(){
        LoginPage loginPage = new LoginPage(driver);
        adminPage = loginPage.correctLogin();
    }

    @When("^user adds new post$")
    public void user_adds_new_post() {
        adminPage.addNewPost("Pending Review", Page.Visibility.PRIVATE);
    }

    @Then("^new post created and visibles on Post page$")
    public void new_post_created_and_visibles_on_Post_page() {
        adminPage.findPost();
    }
}
