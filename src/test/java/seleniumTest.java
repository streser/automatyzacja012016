import org.junit.*;

public class seleniumTest extends seleniumTestSprint {

    @Test
    public void shouldAgileCoachingWebpageBeAccessible(){
        clickByLink("Szkolenia");
        assertIfElementHasText("Szkolenia");
        clickElementById("mt-dla-testerow");
        assertIfLinkElementHasText("Automatyzacja Testów", "Automatyzacja Testów");
        clickByLink("Coaching");
        assertIfElementHasText("Agile Coaching");
    }

    @Test
    public void shouldLeadingSAFeCourseBeAvailable(){
        clickByLink("Szkolenia");
        clickElementById("mt-dla-organizacji");
        assertIfLinkElementHasText("Leading SAFe", "Leading SAFe");
    }
}


