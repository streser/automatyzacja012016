package eu.ekinnolab.test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class StreserNazwaPlTest extends SeleniumBase {
	private String postTitle = "placeholder";
	private WebElement myPost;
	
	@Before
	public void setUpStreserNazwaPl() {
		baseUrl = "http://streser.nazwa.pl/szkolenie/";
	}
	
	@Test
	public void shouldNewPostBeAddedAndDeleted() {
		this.postTitle = "Kamil post, time: " + System.currentTimeMillis();

		login("admin", "password");
		goToAddNewPostForm();
		addNewPost(this.postTitle);
		goToPostsList();
		assertThatPostIsAdded(this.postTitle);
		deleteAddedPost(this.postTitle);
		assertThatPostIsNotPresent();
	}

	public void login(String username, String password) {
		driver.get(baseUrl);
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
	}
	
	public void goToAddNewPostForm() {
		driver.findElement(By.linkText("Posts")).click();
		driver.findElement(By.linkText("Add New")).click();
	}
	
	public void addNewPost(String myPostTitle) {
		setPostTitleAndContent(myPostTitle);
//		setAdditionalPostProperties();
		submitForm();
	}

	public void submitForm() {
		try {
			driver.findElement(By.id("publish")).click();
		} catch (org.openqa.selenium.UnhandledAlertException e) {
			driver.switchTo().alert().accept();
		}
	}

	public void setAdditionalPostProperties() {
		driver.findElement(By.id("post-format-status")).click();
	}

	public void setPostTitleAndContent(String title) {
		String postContent = "From your comments, it seems like you're looking for best practices for the use of the Boolean wrapper class. But there really aren't any best practices, because it's a bad idea to use this class to begin with. The only reason to use the object wrapper is in cases where you absolutely must (such as when using Generics, i.e., storing a boolean in a HashMap<String, Boolean> or the like). Using the object wrapper has no upsides and a lot of downsides, most notably that it opens you up to NullPointerExceptions.";
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("content")).sendKeys(postContent);
	}
	
	public void goToPostsList() {
		driver.findElement(By.linkText("All Posts")).click();
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	private void assertThatPostIsAdded(String postTitle) {
		this.myPost = driver.findElement(By.linkText(postTitle));
		System.out.println("Found: " + postTitle);
	}
	
	private void deleteAddedPost(String postTitle) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText(postTitle))).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		By by = By.className("submitdelete");
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).click();
	}
	
	private void assertThatPostIsNotPresent() {
	    try {
	    	driver.findElement(By.linkText(postTitle));
	    } catch (NoSuchElementException ex) { 
	       Assert.assertTrue(true);
	    }
	}
}
