import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class streserSzkolenieTest extends seleniumBase {
    @Test
    public void shouldUserBeAbleToAddPublishAndDeletePost(){
        clickByLink("Posts");
        clickByLink("Add New");
        String title = uuid.toString() + " Piotr";
        insertTextIntoField("title",title);
        insertTextIntoField("content","ble");
        clickById("publish");
        assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");
        clickByLink("View post");
        assertIfDisplayedPostHasName(title);
        openWebpage("http://streser.nazwa.pl/szkolenie/wp-admin/");
        clickByLink("Posts");
        clickCheckboxOfPost(title);
        clickSelectedFieldInForm("Move to Trash");
        assertIfDisplayedMessageHasText("1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");
    }
}
