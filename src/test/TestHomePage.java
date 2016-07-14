package test;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class TestHomePage extends BaseTest {
    private String expectedSloganPrefix = "Our platform";
    private String expectedSections[] = {
            "Data is a valuable asset.",
            "We transform data into insights.",
            "We enable companies to take action."};

    @Test
    public void verifyContent() {
        HomePage homePage = new HomePage(driver).openPageByUrl();
        assertThat(homePage.getMainSlogan(), containsString(expectedSloganPrefix));
        assertThat(homePage.allSectionsTitles(), contains(expectedSections));
    }
}
