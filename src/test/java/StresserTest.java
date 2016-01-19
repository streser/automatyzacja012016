import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Administrator on 2016-01-19.
 */
public class StresserTest extends BaseTest {

    private String uuid;

    @Test
    public void shouldAddNewPost() {


        String title = UUID.randomUUID().toString().replaceAll("-", "");

        logIn("admin", "password");
        goToPostCreationPage();
        createAndPublish(title);

        goToBlog();
        assert isPostPresent(title);

        goToPostsList();
        removePost(title);

        goToBlog();
        assert !isPostPresent(title);

    }

    private void removePost(String title) {
        clickElement(findWebElementById(getCheckBoxId(title)));
        selectSelectByValue("bulk-action-selector-bottom", "trash");
        clickElement(findWebElementById("doaction2"));
    }

    private void goToPostCreationPage() {
        goToPage("http://streser.nazwa.pl/szkolenie/wp-admin");
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementByText("Add New"));
    }

    private void goToPostsList() {
        goToPage("http://streser.nazwa.pl/szkolenie/wp-admin");
        clickElement(findWebElementByText("Posts"));
    }

    private void createAndPublish(String title) {
        writTextToElement(title, findWebElementById("title"));
        writTextToElement("Testowa wiadomość", findWebElementById("content"));
        clickElement(findWebElementById("publish"));
    }

    private boolean isPostPresent(String title) {
        try {
            return title.equals(findWebElementByText(title).getText());
        }catch (Exception e){
            return false;
        }
    }

    private void goToBlog() {
        goToPage("http://streser.nazwa.pl/szkolenie");
    }

    private void logIn(String admin, String password) {
        goToPage("http://streser.nazwa.pl/szkolenie");
        clickElement(findWebElementByText("Log in"));
        writTextToElement(admin, findWebElementById("user_login"));
        writTextToElement(password, findWebElementById("user_pass"));
        clickElement(findWebElementById("wp-submit"));
    }

    public String getCheckBoxId(String title){
        WebElement element = findWebElementByText(title);
        String link = element.getAttribute("href");
        link = link.substring((link.indexOf("post=")+5));
        String id = "";
        for(Character s: link.toCharArray()){
            if(s.toString().equals("&")) break;
            id += s.toString();
        }
        return "cb-select-"+id;
    }


}
