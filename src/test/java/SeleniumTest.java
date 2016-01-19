import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class SeleniumTest extends SeleniumBase {

    @Test
    public void ShouldProveThatAllLinksAreActive() throws Exception {
        //given
        driver.get(baseUrl);
        //when
        WebElement szkolenia = FindElementByLinkText("Szkolenia");
        ClickElement(szkolenia);
        WebElement dlaOrganizacji = FindElementById("mt-dla-organizacji");
        ClickElement(dlaOrganizacji);
        WebElement leadingSafe = FindElementByLinkText("Leading SAFe");
        //then
        assertEquals("Leading SAFe", leadingSafe.getText());

    }
}

