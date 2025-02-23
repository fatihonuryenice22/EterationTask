package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    ElementHelper elementHelper;
    public MainPage(WebDriver driver){
        this.driver=driver;
        this.elementHelper=new ElementHelper(driver);
    }
    //Elements
    public By logo=By.xpath("//div[@class='logo']");
    By instructorsButton=By.xpath("//a[normalize-space()='Eğitmenler']");

    public void clickToInstructors() {
        elementHelper.checkVisible(instructorsButton);
        elementHelper.Click(instructorsButton);
    }


}
