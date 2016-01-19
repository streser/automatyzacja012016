package eu.ekinnolab.test;

import org.openqa.selenium.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class SearchInXpathPage {

	private WebDriver driver;
	private String xPostMenu = "//div[text()='Posts']";
	private String xAddNew = "//a[text()='Add New']";
	private String xCheckBoxToDelete = "//a[text()='%s']/ancestor::tr/th/input";
	private String xTrashToDelete = "//a[text()='%s']/ancestor::tr//a[text()='Trash']";

	public SearchInXpathPage(WebDriver driver) {
		this.driver = driver;
	}

	public void AddNew() {

		driver.findElement(By.xpath(xPostMenu)).click();
		driver.findElement(By.xpath(xAddNew)).click();
	}

	public void DeletePost() {
		String title = "title of randomly generated content";
		driver.findElement(By.xpath(String.format(xCheckBoxToDelete, title))).click();
		driver.findElement(By.xpath(String.format(xTrashToDelete, title))).click();
	}

}
