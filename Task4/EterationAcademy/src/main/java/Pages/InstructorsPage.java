package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;
import java.util.List;

public class InstructorsPage {
    WebDriver driver;
    public InstructorsPage(WebDriver driver){
        this.driver=driver;
    }

    public int countDivs(){
        int count=1;
         while(true){
             String xpathOfInstructors="/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div["+count+"]/div[2]";
             List< WebElement> elements=driver.findElements(By.xpath(xpathOfInstructors));
             if (elements.isEmpty()){
                 break;
             }
             count++;
         }

        return count-1;
    }
}
