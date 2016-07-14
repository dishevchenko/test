package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class HomePage extends BasePage {
    private String homeUrl = "http://uptake.com/";

    @FindBy(xpath = "//h1[contains(@class,'hero-title')]")
    private WebElement homeSlogan;

    @FindBy(xpath = "//div[@class='l-wrap']//h2")
    private List<WebElement> allSections;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        log.info("Checking if" + getClass().getSimpleName() + " is loaded");
        boolean isCurrentUrl = driver.getCurrentUrl().equals(homeUrl);
        boolean isSloganDisplayed = !homeSlogan.getText().isEmpty();
        return isCurrentUrl && isSloganDisplayed;
    }

    public HomePage openPageByUrl() {
        driver.get(homeUrl);
        waitForLoad();
        return this;
    }

    public String getMainSlogan() {
        return homeSlogan.getText();
    }

    public List<String> allSectionsTitles() {
        ArrayList<String> allSectionsText = new ArrayList<>();
        //Next can be changed with a cool Java8 stream API, but let's leave for easier reading
        for (WebElement section : allSections) {
            allSectionsText.add(section.getText());
        }
        log.info("Page has sections titles: " + allSectionsText);
        return allSectionsText;
    }
}
