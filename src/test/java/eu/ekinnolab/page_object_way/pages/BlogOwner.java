package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class BlogOwner {
	LoginPage atLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}
}
