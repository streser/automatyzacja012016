package wordpress;
import org.junit.Test;


import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;
import wordpress.pages.Base;
import wordpress.pages.Page;


public class PostsTest extends Base{

    @Test
    public void shouldBePossibleToCreatePost(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Open();

        AdminPage adminPage = loginPage.correctLogin();
        adminPage.addNewPost("Pending Review", Page.Visibility.PRIVATE);
        adminPage.findPost();
    }
}
