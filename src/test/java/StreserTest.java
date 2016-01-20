import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016-01-19.
 */
public class StreserTest extends SeleniumBase {

    private String title = UUID.randomUUID().toString();;

    @Test
    public void ShouldAddPost() {

        UserLogin("admin", "password");

        GoToPostCreationPage();
        CreateAndPublish(title);

        GoToBlog();
       assert IsPostPresent(title);

        GoToPostsList();

        RemovePost(title);

        GoToBlog();
     //   assert IsPostPresent(title) == false;

    }

    protected void RemovePost(String title) {
        WebElement postsTable = FindElementByClassName("wp-list-table");
        WebElement row = FindTableRowByText(postsTable,  title);
        ClickElement(row);
        WebElement trashLink = FindElementByLinkText("Trash");
        ClickElement(trashLink);
    }

    protected void GoToPostsList() {
        GetUrl("http://streser.nazwa.pl/szkolenie/wp-admin/edit.php");
    }

    protected boolean IsPostPresent(String title) {
        WebElement recentlyAddeedPost = FindElementByLinkText(title);
        return this.title.equals(recentlyAddeedPost.getText());
    }

    protected void GoToBlog() {
        GetUrl("http://streser.nazwa.pl/szkolenie/");
    }

    protected void CreateAndPublish(String title) {
        WebElement postTextBox = FindElementById("title-prompt-text");
        InsertText(postTextBox, title);
        WebElement publishButton = FindElementById("publish");
        ClickElement(publishButton);
    }

    protected void GoToPostCreationPage() {
        WebElement postLink = FindElementByLinkText("Posts");
        ClickElement(postLink);
        WebElement addPost = FindElementByLinkText("Add New");
        ClickElement(addPost);
    }

    protected void UserLogin(String login, String password) {
        GoToBlog();
        WebElement loginLink = FindElementByLinkText("Log in");
        ClickElement(loginLink);
        WebElement usernameTextbox = FindElementById("user_login");
        InsertText(usernameTextbox, login);
        WebElement passwordTextbox = FindElementById("user_pass");
        InsertText(passwordTextbox, password);
        WebElement loginBtn = FindElementById("wp-submit");
        ClickElement(loginBtn);
    }

    //label[text()='Seaside & Country Homes']/preceding-sibling::input[@type='checkbox']
}


