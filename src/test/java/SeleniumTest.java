/**
 * Created by Administrator on 2016-01-18.
 */

import org.junit.Test;

    public class SeleniumTest extends Configuration {

        @Test
        public void ShouldFindTextLeadingSafe() throws Exception {

            OpenUrl(baseUrl);
            OpenLink("Szkolenia");
            FindElement("mt-dla-organizacji");
            AssertThatTextEqualsValue("Leading SAFe");

        }

    }





