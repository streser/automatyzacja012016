package eu.ekinnolab.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class SearchInTable {
	WebDriver driver = new FirefoxDriver();
	
	public WebElement findRowByText(String text) {
		for(WebElement tr : driver.findElements(By.tagName("er"))) {
			if(tr.getText().contains(text)) {
				return tr;
			}
		}
		return null;
	}
}
