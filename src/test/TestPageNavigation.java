package test;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SolutionsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmytro on 10.07.2016.
 */
public class TestPageNavigation extends BaseTest {

    @Test
    public void verifyNavigationBetweenPages() {
        HomePage homePage = new HomePage(driver).openPageByUrl();
        SolutionsPage solutionsPage = homePage.navigateToPage(BasePage.MENU.SOLUTIONS, SolutionsPage.class);
        assertThat(solutionsPage.isLoaded(), is(true));
        homePage = solutionsPage.backspaceNavigation(HomePage.class);
        assertThat(homePage.isLoaded(), is(true));
    }

}
