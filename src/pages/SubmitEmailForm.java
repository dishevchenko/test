package pages;

import com.thoughtworks.selenium.SeleniumException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class SubmitEmailForm {
    private WebDriver driver;
    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[contains(@class,'response-output') and @role='alert']")
    private WebElement alertMessage;

    public SubmitEmailForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSubmit() {
        sendButton.click();
    }

    public String getAlertMessage() {
        try {
            return alertMessage.getText();
        } catch (SeleniumException e) {
            e.printStackTrace();
            return null;
        }
    }
}
