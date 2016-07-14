package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class BaseTest {
    WebDriver driver;
    final Logger log = Logger.getLogger(getClass());

    @BeforeClass
    public void setup() {
        log.info("Opening a new browser session for: " + this.getClass().getSimpleName());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void shutDown() {
        log.info("Closing browser after test");
        driver.quit();
    }
}
