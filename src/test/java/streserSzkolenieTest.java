import org.junit.*;

public class streserSzkolenieTest extends seleniumBase {
    @Test
    public void shouldUserBeAbleToAddPublishDeletePost(){
        String title = uuid.toString() + " Piotr";

        addPost(title);
        assertIfDisplayedMessageHasText("Post published. View post\n" +
                "Dismiss this notice.");

        viewCreatedPost();
        assertIfDisplayedPostHasName(title);

        openWebpage(listOfAllPostsUrl);
        deletePost(title);
        assertIfDisplayedMessageHasText("1 post moved to the Trash. Undo\n" +
                "Dismiss this notice.");
    }
}
