package wordpress;

import junit.runner.BaseTestRunner;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import wordpress.pages.AddNewPostPage;
import wordpress.pages.AdminPage;
import wordpress.pages.BlogPage;
import wordpress.pages.LoginPage;

import java.util.UUID;

import static com.thoughtworks.selenium.SeleneseTestBase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-01-19.
 */
public class PostTest extends BaseTest{

    @Test
    public void shouldBeCorrectLogIn(){
        String title = UUID.randomUUID().toString();
        //GIVEN
        LoginPage lp = new LoginPage(driver);
        lp.open();
        AdminPage ap = lp.correctLogin();
        //WHEN
        AddNewPostPage anpp = ap.goToAddNewPostPage();
        anpp.addNewPost(title);
        //THEN
        BlogPage bp = anpp.goToBlog();
        assertTrue(bp.isPostVisible(title));
        ap = bp.goToAdminPage();
        ap.goToPostListAndClickInTitle(title);
        ap.editVisibility();
        ap.goToBlog();
        assertFalse(bp.isPostVisible(title));
    }

}
