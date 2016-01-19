package wordpress;

import junit.runner.BaseTestRunner;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import wordpress.pages.AddNewPostPage;
import wordpress.pages.AdminPage;
import wordpress.pages.BlogPage;
import wordpress.pages.LoginPage;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-01-19.
 */
public class PostTest extends BaseTest{

    @Test
    public void shouldBeCorrectLogIn(){
        String title = UUID.randomUUID().toString();
        LoginPage lp = new LoginPage(driver);
        lp.open();

        AdminPage ap = lp.correctLogin();
        AddNewPostPage anpp = ap.goToAddNewPostPage();
        anpp.addNewPost(title);
        BlogPage bp = anpp.goToBlog();
        assertTrue(bp.isPostVisible(title));
    }

}
