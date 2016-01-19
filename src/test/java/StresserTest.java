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
        uuid = UUID.randomUUID().toString().replaceAll("-", "");
        giveNewPost();
        whenPostAddVerifyIt();
        thenDropPost();
    }

    public void giveNewPost(){
        goToPage("http://streser.nazwa.pl/szkolenie");
        clickElement(findWebElementByText("Log in"));
        writTextToElement("admin", findWebElementById("user_login"));
        writTextToElement("password", findWebElementById("user_pass"));
        clickElement(findWebElementById("wp-submit"));
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementByText("Add New"));
        writTextToElement(uuid, findWebElementById("title"));
        writTextToElement("Testowa wiadomosc", findWebElementById("content"));
        clickElement(findWebElementById("publish"));
    }

    public void whenPostAddVerifyIt(){
        goToPage("http://streser.nazwa.pl/szkolenie");
        Assert.assertEquals(uuid, findWebElementByText(uuid).getText());
    }

    public void thenDropPost(){
        goToPage("http://streser.nazwa.pl/szkolenie/wp-admin/");
        clickElement(findWebElementByText("Posts"));
        clickElement(findWebElementById(getCheckBoxId()));
        selectSelectByValue("bulk-action-selector-bottom", "trash");
        clickElement(findWebElementById("doaction2"));
    }

    public String getCheckBoxId(){
        WebElement element = findWebElementByText(uuid);
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
