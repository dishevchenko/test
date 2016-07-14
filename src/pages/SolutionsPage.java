package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class SolutionsPage extends BasePage {
    private String solutionsUrl = "http://uptake.com/solutions/";

    @FindBy(xpath = "//h2[contains(@class,'hero-title')]")
    private WebElement solutionsSlogan;

    @FindBy(xpath = "//a[contains(@class,'email_open')]")
    private WebElement emailLink;

    public SolutionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        log.info("Checking if " + getClass().getSimpleName() + " is loaded");
        boolean isCurrentUrl = driver.getCurrentUrl().equals(solutionsUrl);
        boolean isSloganDisplayed = !getMainSlogan().isEmpty();
        return isCurrentUrl && isSloganDisplayed;
    }

    public SolutionsPage openPageByUrl() {
        driver.get(solutionsUrl);
        waitForLoad();
        return this;
    }

    public String getMainSlogan() {
        return solutionsSlogan.getText();
    }

    public SubmitEmailForm openSubmitEmailForm() {
        emailLink.click();
        log.info("Opening a form for sending Email");
        return new SubmitEmailForm(driver);
    }
}
