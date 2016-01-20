package wordpress;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import wordpress.pages.AdminPage;
import wordpress.pages.LoginPage;
import wordpress.pages.SeleniumBase;

import java.util.UUID;

public class PostsTest extends SeleniumBase{
    String title = UUID.randomUUID().toString() + " Piotr";
    @Test
    public void shouldBePossibleToAddNewBlogPage(){
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.correctLogin("admin", "password");
        AdminPage ap = new AdminPage(driver);
        ap.addPost(title);
        ap.assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");

        ap.viewCreatedPost();
        ap.assertIfDisplayedPostHasName(title);

        ap.openWebpage("http://streser.nazwa.pl/szkolenie/wp-admin/");
        ap.deletePost(title);
        ap.assertIfDisplayedMessageHasText("1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");

        System.out.println("test");
    }

}
