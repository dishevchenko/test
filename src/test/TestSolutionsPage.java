package test;

import org.testng.annotations.Test;
import pages.SolutionsPage;
import pages.SubmitEmailForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/**
 * Created by Dmytro on 10.07.2016.
 */
public class TestSolutionsPage extends BaseTest {
    private String expectedSlogan = "Our industry solutions improve uptime, minimize failures, reduce fuel costs, and streamline operations.";
    private String expectedWarning = "Validation errors occurred. Please confirm the fields and submit it again.";

    @Test(priority = 1)
    public void verifySolutionsContent() {
        SolutionsPage solutionsPage= new SolutionsPage(driver).openPageByUrl();
        assertThat(solutionsPage.isLoaded(), is(true));
        assertThat(solutionsPage.getMainSlogan(), is(expectedSlogan));
    }

    @Test (priority = 2)
    public void verifyErrorIfEmptyContactsSent() {
        //Negative test
        SolutionsPage solutionsPage= new SolutionsPage(driver).openPageByUrl();
        SubmitEmailForm submitEmailForm = solutionsPage.openSubmitEmailForm();
        submitEmailForm.clickSubmit();
        log.info("Trying to send an empty form");
        assertThat(submitEmailForm.getAlertMessage(), is(expectedWarning));
    }
}
