package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Kamil Tor on 19 sty 2016
 */

public abstract class Page {
	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	BlogOwner blogOwner = new BlogOwner();
}
