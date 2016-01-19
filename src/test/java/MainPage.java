import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-01-19.
 */
public class MainPage {

    private WebDriver driver;
    private String xPostMenu = "//div[text()='Posts']";
    private String xAddNew = "//a[text()='Add New']";
    private String xCheckBoxToDelete = "//a[text()='%s']/ancestor::tr/th/input";
    private String xTrashToDelete = "//a[text()='%s']/ancestor::tr//a[text()='Trash']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewPostPage AddNew() {

        driver.findElement(By.xpath(xPostMenu)).click();
        driver.findElement(By.xpath(xAddNew)).click();
        return new NewPostPage(driver);
    }

    public MainPage DeletePost(){

        String title = NewPostPage.title;
        driver.findElement(By.xpath(String.format(xCheckBoxToDelete,title))).click();
        driver.findElement(By.xpath(String.format(xTrashToDelete,title))).click();
        return this;
    }


}