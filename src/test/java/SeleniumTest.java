/**
 * Created by Administrator on 2016-01-18.
 */

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

    public class SeleniumTest extends Configuration {

        @Test
        public void ShouldFindTextLeadingSafe() throws Exception {

            OpenUrl(baseUrl);
            OpenLink("Szkolenia");
            FindElement("mt-dla-organizacji");
            AssertThatTextEqualsValue("Leading SAFe");

        }

        public void OpenUrl(String url)
        {
            driver.get(url);
        }

        public void OpenLink(String linkToOpen)
        {
            driver.findElement(By.linkText(linkToOpen)).click();
        }

        public void FindElement(String id)
        {
            driver.findElement(By.id(id)).click();
        }

        public void AssertThatTextEqualsValue(String textToCheck)
        {
            assertEquals(textToCheck, driver.findElement(By.linkText(textToCheck)).getText());
        }

    }





