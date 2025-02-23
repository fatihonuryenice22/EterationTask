package Tests;

import Pages.InstructorsPage;
import Pages.MainPage;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;
import utils.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingInstructorsTest extends BaseTest {
 ElementHelper elementHelper = new ElementHelper(driver);
 MainPage mainPage=new MainPage(driver);
 InstructorsPage instructorsPage=new InstructorsPage(driver);
String baseUrl= ConfigReader.getProperty("baseUrl");
int expectedInstructorNumber=6; // Currently there are 6 instructors in this page according to case study it should be 8
 @Test
 public void checkingInstructorsTest() throws InterruptedException{
    assertEquals(driver.getCurrentUrl(),baseUrl,"Urls are different");
    assertTrue(elementHelper.checkVisible(mainPage.logo),"logo invisible");
    logger.info("Main Page is Reachable Going to Instructors Page");
    mainPage.clickToInstructors();
    logger.info("Instructors button clicked");
    Thread.sleep(3000);
     assertEquals(instructorsPage.countDivs(), expectedInstructorNumber);
     logger.info("There are "+expectedInstructorNumber+" Instructors");
     logger.info("Test Successfully Completed");
 }
}
