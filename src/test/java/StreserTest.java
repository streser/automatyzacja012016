import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016-01-19.
 */
public class StreserTest extends SeleniumBase {

    @Test
    public void ShouldAddPost() {

        UserLogin();

        WebElement postLink = FindElementByLinkText("Posts");
        ClickElement(postLink);
        WebElement addPost = FindElementByLinkText("Add New");
        ClickElement(addPost);
        WebElement postTextBox = FindElementById("title-prompt-text");
        String title = UUID.randomUUID().toString();
        InsertText(postTextBox, title);
        WebElement publishButton = FindElementById("publish");
        ClickElement(publishButton);

        GetUrl("http://streser.nazwa.pl/szkolenie/");
        WebElement recentlyAddeedPost = FindElementByLinkText(title);
        assertEquals(title, recentlyAddeedPost.getText());

        GetUrl("http://streser.nazwa.pl/szkolenie/wp-admin/edit.php");

        WebElement postsTable = FindElementByClassName("wp-list-table");
        WebElement row = FindTableRowByText(postsTable, title);
        ClickElement(row);
        WebElement trashLink = FindElementByLinkText("Trash");
        ClickElement(trashLink);

    }

    protected void UserLogin() {
        GetUrl("http://streser.nazwa.pl/szkolenie/");
        WebElement loginLink = FindElementByLinkText("Log in");
        ClickElement(loginLink);
        WebElement usernameTextbox = FindElementById("user_login");
        InsertText(usernameTextbox, "admin");
        WebElement passwordTextbox = FindElementById("user_pass");
        InsertText(passwordTextbox, "password");
        WebElement loginBtn = FindElementById("wp-submit");
        ClickElement(loginBtn);
    }

    //label[text()='Seaside & Country Homes']/preceding-sibling::input[@type='checkbox']
}


