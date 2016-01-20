package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class AddNewPostPage extends Page {
	
	public AddNewPostPage(WebDriver driver) {
		super(driver);
	}

	public AddNewPostPage addNewPost(String title) {
		setPostTitleAndContent(title);
		setAdditionalPostProperties();
		submitForm();
		return this;
	}
	
	public void submitForm() {
		try {
			driver.findElement(By.id("publish")).click();
		} catch (org.openqa.selenium.UnhandledAlertException e) {
			driver.switchTo().alert().accept();
		}
	}

	public void setAdditionalPostProperties() {
		changeStatusTo("pending");
		WebElement bar = openOptionsSection("visibility");
		WebElement element = driver.findElement((By.id("post_status")));
		click(By.id("visibility-radio-private"));
		click(bar, By.linkText("OK"));
	}

	public void changeStatusTo(String pending) {
		WebElement bar = openOptionsSection("post-status");
		WebElement element = driver.findElement((By.id("post_status")));
		Select select = new Select(element);
		select.selectByValue(pending);
		click(bar, By.linkText("Cancel"));
	}

	public WebElement openOptionsSection(String ending) {
		WebElement bar = driver.findElement(By.className("misc-pub-" + ending));
		WebElement editButtton = bar.findElement(By.className("hide-if-no-js"));
		editButtton.click();
		return bar;
	}

	public void setPostTitleAndContent(String title) {
		String postContent = "From your comments, it seems like you're looking for best practices for the use of the Boolean wrapper class. But there really aren't any best practices, because it's a bad idea to use this class to begin with. The only reason to use the object wrapper is in cases where you absolutely must (such as when using Generics, i.e., storing a boolean in a HashMap<String, Boolean> or the like). Using the object wrapper has no upsides and a lot of downsides, most notably that it opens you up to NullPointerExceptions.";
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("content")).sendKeys(postContent);
	}

	public PostsListPage goToPostsList() {
		driver.findElement(By.linkText("All Posts")).click();
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		return new PostsListPage(driver);
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
