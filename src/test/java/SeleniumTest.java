/**
 * Created by Administrator on 2016-01-18.
 */

import PageObjectPattern.Configuration;
import org.junit.Test;

    public class SeleniumTest extends Configuration {
        private String baseUrl = "http://agileszkolenia.pl/";

        @Test
        public void ShouldFindTextLeadingSafe() throws Exception {

            OpenUrl(baseUrl);
            OpenLink("Szkolenia");
            FindElement("mt-dla-organizacji");
            AssertThatTextEqualsValue("Leading SAFe");

        }

    }





