package wordpress;

import org.junit.Test;
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
        AdminPage ap = lp.correctLogin("admin", "password");

        ap.addPost(title);
        ap.assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");

        ap.viewCreatedPost();
        ap.assertIfDisplayedPostHasName(title);

        ap.openListOfPosts();
        ap.deletePost(title);
        ap.assertIfDisplayedMessageHasText("1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");

    }

    @Test
    public void shouldBePossibleToAddNewBlogPageWithExtraParameters() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        AdminPage ap = lp.correctLogin("admin", "password");


        ap.addPostWithParameters(title);


        ap.assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");

        ap.viewCreatedPost();
        ap.assertIfDisplayedPostHasNamePrivat("Private: " +title);

        ap.openListOfPosts();

        ap.deletePost(title);
        ap.assertIfDisplayedMessageHasText("1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");


    }



}
