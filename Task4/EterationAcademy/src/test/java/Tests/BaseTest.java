package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected static WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @AfterEach
    public void tearDown(){
        logger.info("Test Finished Closing Browser");
        DriverFactory.quitDriver(driver);
    }
    @BeforeAll
    public static void setUp(){
        logger.info("Test Starting");
        String baseUrl = ConfigReader.getProperty("baseUrl");
        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.initializeDriver(browser);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

}
