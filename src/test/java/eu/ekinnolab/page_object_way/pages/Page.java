package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */

public abstract class Page {
	WebDriver driver;
	BlogOwner blogOwner = new BlogOwner();

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(WebElement element, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element.findElement(by).click();
	}
	
	public void click(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).click();
	}
	
	public void wait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	
}
