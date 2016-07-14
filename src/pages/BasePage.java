package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BrowserHelper;

/**
 * Created by Dmytro on 10.07.2016.
 */
public abstract class BasePage extends BrowserHelper {
    final Logger log = Logger.getLogger(getClass());
    private static String menuLocatorPrefix = "//div[@class='primary-nav']//a[.='%s']";

    /**
     * Checks if current page is loaded
     *
     * @return true or false
     */
    public abstract boolean isLoaded();

    /**
     * @return Text of the main slogan for the page
     */
    public abstract String getMainSlogan();

    /**
     * Navigates to a particular page from a current page
     *
     * @param expectedPage to which we need to navigate
     * @return instance of class for page to which we navigated
     */
    public <T extends BasePage> T navigateToPage(MENU buttonToPage, Class<T> expectedPage) {
        try {
            By buttonXpath = By.xpath(String.format(menuLocatorPrefix, buttonToPage.getName()));
            WebElement buttonAsWebElement = driver.findElement(buttonXpath);
            buttonAsWebElement.click();
            log.info("Navigation via menu to: " + expectedPage.getSimpleName());
            T page = PageFactory.initElements(driver, expectedPage);
            page.waitForLoad();
            return page;
        } catch (Exception e) {
            log.info("Could NOT switch to page " + buttonToPage);
            throw e;
        }
    }

    /**
     * Opens a particular page by URL in address line
     *
     * @return instance of class for page to which we navigated
     */
    public abstract <T extends BasePage> T openPageByUrl();

    /**
     * Navigation to a previous page
     *
     * @param expectedPage page we want to see
     * @return <T> instance of page class
     */
    public <T extends BasePage> T backspaceNavigation(Class<T> expectedPage) {
        driver.navigate().back();
        log.info("Navigation back to: " + expectedPage.getSimpleName());
        return PageFactory.initElements(driver, expectedPage);
    }

     void waitForLoad() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public enum MENU {
        APPROACH("Approach"),
        PLATFORM("Platform"),
        SOLUTIONS("Solutions"),
        PEOPLE("People"),
        JOIN_US("Join Us"),
        BLOG("Blog");

        public String name;

        MENU(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
