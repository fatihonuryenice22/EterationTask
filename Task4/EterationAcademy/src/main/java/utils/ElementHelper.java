package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {
    //Makes the element interactions with this java class
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action=new Actions(driver);
    }
    public WebElement presenceElement(By key){
        return
                wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }
    public WebElement findElement(By key){
        WebElement element= presenceElement(key);
        return element;
    }
    public void Click(By key ){
        findElement(key).click();
    }
    public void sendKeys(By key,String text){
        findElement(key).sendKeys(text);
    }
    public boolean checkVisible(By key) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(key)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
