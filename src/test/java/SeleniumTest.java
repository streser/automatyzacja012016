
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest extends BaseTest {

    @Test
    public void shouldCheckIfLeadingSafeExist() throws Exception {
        goToPage("http://agileszkolenia.pl/");
        clickElement(findWebElementByText("Szkolenia"));
        clickElement(findWebElementById("mt-dla-organizacji"));
        clickElement(findWebElementByText("Leading SAFe"));
    }

    //@Test
    public void shouldCheckIfLeadingSageExistBySeleniumIDE() throws Exception {
        goToPage("http://agileszkolenia.pl/");
        clickElement(findWebElementByText("Szkolenia"));
        clickElement(findWebElementById("mt-dla-organizacji"));
        clickElement(findWebElementByText("Leading SAFe"));
    }


}
