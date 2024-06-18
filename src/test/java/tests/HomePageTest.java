package tests;

import base.AbstractWebTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pagesobject.features.HomePage;

import java.util.List;

import static constants.strings.Messages.*;

public class HomePageTest extends AbstractWebTest {
    @Test
    public void home_page_testing() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(WHAT_HOT_TAB_NOT_SHOWED, homePage.isWhatsHotTabDisplayed());
        homePage.clickWhatsHotTab();

        List<WebElement> slides = homePage.getSlickSlides();
        Assert.assertFalse(NO_SLIDES_FOUND, slides.isEmpty());

        String initialSlideText = homePage.getCurrentSlideText();
        homePage.waitForSlideChange(initialSlideText, 2); // Wait for the slide to change, assuming the slide changes within 2 seconds
        String newSlideText = homePage.getCurrentSlideText();
        Assert.assertNotEquals(initialSlideText, newSlideText, SLIDER_NOT_AUTO_MOVE);
    }
}
