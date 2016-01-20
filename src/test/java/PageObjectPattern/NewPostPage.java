package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

/**
 * Created by Administrator on 2016-01-19.
 */
public class NewPostPage extends Page {

    private String xAllNewTests = "//a[text()='All Posts']";
    private String xEditStatus = "//a[@href='#post_status']/span[text()='Edit']";
    private String xVisibilityEdit = "//a[@href='#visibility']/span[text()='Edit']";
    private String xVisibilityStatus = "//label[text()='%s']";
    private String xPostStatus = "//select[@id='post_status']/option[text()='%s']";
    private String xPublicRadioButton = "//label[text()='Public']";
    private String xOkButtonPostStatus = "//a[@href='#post_status' and text()='OK']";
    private String xOKButtonVisibility = "//a[@href='#visibility' and text()='OK']";
    public static String title;

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public NewPostPage AddPost() {
        title = "MS" + UUID.randomUUID().toString();
        driver.findElement(By.id("title")).sendKeys(title);
        SetPostAttributes("Pending Review","Private");
        driver.findElement(By.id("publish")).click();
        return this;
    }

    public MainPage ViewAllPost() {
        driver.findElement(By.xpath(xAllNewTests)).click();
        return new MainPage(driver);
    }

    public void SetPostAttributes(String status, String visibility) {

        driver.findElement((By.xpath(xEditStatus))).click();//click edit
        WaitForElement(By.id("post_status"));
        driver.findElement(By.id("post_status")).click();
        driver.findElement(By.xpath(String.format(xPostStatus, status))).click();
        driver.findElement((By.xpath(xOkButtonPostStatus))).click();//click OK Button
        driver.findElement(By.id("post_status")).click();
        driver.findElement(By.xpath(xVisibilityEdit)).click();//click edit
        WaitForElement(By.xpath(xPublicRadioButton));
        driver.findElement(By.xpath(String.format(xVisibilityStatus,visibility))).click();
        driver.findElement(By.xpath(xOKButtonVisibility)).click();//click ok

    }

}