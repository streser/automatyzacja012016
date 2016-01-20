package eu.ekinnolab.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

public class WrittenSeleniumTest extends SeleniumBase {

	public void givenIamOnMainPage() {
		driver.get(baseUrl + "/");
	}

//	@Test
	public void testSeleniumManually() throws Exception {
		givenIamOnMainPage();
		whenIgoToOrganizationSection();
		thenIshouldSeeSafeWorkshop();
	}

	public void thenIshouldSeeAgileCoachingOffer() {
		assertEquals("Agile Coaching", driver.findElement(By.cssSelector("h1.entry-title")).getText());
	}

	public void thenIshouldSeeSafeWorkshop() {
		driver.findElement(By.linkText("Leading SAFe"));
	}

	public void whenIGoToCoachingSection() {
		driver.findElement(By.linkText("Konsulting")).click();
		driver.findElement(By.linkText("Szkolenia")).click();
		driver.findElement(By.id("mt-dla-testerow")).click();
		driver.findElement(By.linkText("Coaching")).click();
	}

	public void whenIgoToOrganizationSection() {
		driver.findElement(By.id("menu-item-181")).click();
		driver.findElement(By.id("mt-dla-organizacji")).click();
	}
}
