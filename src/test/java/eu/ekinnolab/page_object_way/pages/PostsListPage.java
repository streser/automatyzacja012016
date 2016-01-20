package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class PostsListPage extends Page {

	public PostsListPage(WebDriver driver) {
		super(driver);
	}

	public boolean isPostPresent(String title) {
		driver.findElement(By.linkText(title));
		System.out.println("Found: " + title);
		return true;
	}

}
