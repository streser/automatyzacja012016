package wordpress;
import org.junit.Test;


import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;
import wordpress.pages.SeleniumBase;


public class PostsTest extends SeleniumBase{

    public PostsTest(){
        super(driver);
    }

    @Test
    public void shouldBePossibleToCreatePost(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Open();

        AdminPage adminPage = loginPage.correctLogin();
        adminPage.addNewPost("Pending Review", "private");
        adminPage.findPost();
    }
}
