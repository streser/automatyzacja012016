package wordpress;
import org.junit.Test;


import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;
import wordpress.pages.Base;


public class PostsTest extends Base{

    public PostsTest(){
        super(driver);
    }

    @Test
    public void shouldBePossibleToCreatePost(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Open();

        AdminPage adminPage = loginPage.correctLogin();
        adminPage.addNewPost("Pending Review", Visibility.PRIVATE);
        adminPage.findPost();
    }
}
