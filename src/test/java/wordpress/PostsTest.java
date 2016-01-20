package wordpress;

import org.junit.Test;
import wordpress.Pages.*;

import java.util.UUID;

/**
 * Created by Administrator on 2016-01-19.
 */
public class PostsTest extends PageObjectPatternBase {


    private String title = UUID.randomUUID().toString();

    @Test
    public void ShouldAddPost() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Open();
        AdminPage adminPage = loginPage.CorrectLogin("admin", "password");
        EditPage editPage = adminPage.GoToAddNewPostPage(title);
        editPage.AddNewPost(title);
        FrontPage frontPage = editPage.GoToFrontPage();
        assert frontPage.isPostDisplayed(title);
    }
}