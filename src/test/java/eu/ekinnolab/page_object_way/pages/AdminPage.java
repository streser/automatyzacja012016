package eu.ekinnolab.page_object_way.pages;

import org.openqa.selenium.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class AdminPage extends Page {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return true;
	}

	public AddNewPostPage goToAddNewPostPage() {
		driver.findElement(By.linkText("Posts")).click();
		driver.findElement(By.linkText("Add New")).click();
		return new AddNewPostPage(driver);
	}


}
