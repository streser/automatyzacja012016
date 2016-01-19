import org.junit.Test;
import org.openqa.selenium.*;
import static org.junit.Assert.*;

public class SeleniumTest extends SeleniumAbstractTest {


    @Test
    public void isMainPageAvailable(){
        assertEquals(driver.findElement(By.xpath("//div[3]/div[1]/div/div[3]/div")).getText(), "Oferta\nNasze Usługi");
    }

    @Test
    public void shouldSzkoleniaPageBeAvailable(){
        driver.findElement(By.linkText("Szkolenia")).click();
        WebElement  element = driver.findElement(By.className("entry-title"));
        assertEquals(element.getText(), "Szkolenia");
    }

    @Test
    public void shouldKonsultingPageBeAvailable(){
        driver.findElement(By.linkText("Konsulting")).click();
        assertEquals("Konsulting metod Agile (Scrum, Kanban, SAFe), procesy IT", driver.getTitle());

    }

    @Test
    public void shouldCoachingPageBeAvailable(){
        driver.findElement(By.linkText("Coaching")).click();
        assertEquals("Agile Coaching - Code Sprinters", driver.getTitle());
    }
}

