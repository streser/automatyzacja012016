package PageObjectPattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016-01-19.
 */
public class StreserTest extends Configuration {

    @Test
    public void ShouldAddPostandDelete(){

        OpenUrl(baseUrl);
        LoginPage login = new LoginPage(driver);
        MainPage main = login.LogIn();
        NewPostPage postPage = main.AddNew();
        postPage.AddPost();
        main = postPage.ViewAllPost();
        Assert.assertTrue(main.isPostPresent());
        main.DeletePost();

    }




}
