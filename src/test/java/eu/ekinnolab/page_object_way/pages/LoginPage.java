package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		driver.get("http://streser.nazwa.pl/szkolenie/");
		
	}
	
	public AdminPage correctLogin() {
		login("admin", "password");
		return new AdminPage(driver);
	}

	public AdminPage login(String username, String password) {
		try {
			driver.findElement(By.linkText("Log in")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.linkText("Log out"));
			driver.get("http://streser.nazwa.pl/szkolenie/wp-admin/");
		}
		
		WebElement loginField = driver.findElement(By.id("user_login"));
		WebElement passwordField = driver.findElement(By.id("user_pass"));
		WebElement submitButton = driver.findElement(By.id("wp-submit"));
		
		loginField.sendKeys(username);
		passwordField.sendKeys(password);
		submitButton.click();
		return new AdminPage(driver);
	}

}
