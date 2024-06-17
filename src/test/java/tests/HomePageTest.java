package tests;

import base.AbstractWebTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pagefactory.PageFactoryManager;
import pagesobject.features.HomePage;

import java.util.List;

public class HomePageTest extends AbstractWebTest {
    @Test
    public void home_page_testing() {
        HomePage homePage = PageFactoryManager.initElements(driver, HomePage.class);
        homePage.open();
        Assert.assertTrue("'What’s hot!?' tab is not displayed.", homePage.isWhatsHotTabDisplayed());
        homePage.clickWhatsHotTab();

        List<WebElement> slides = homePage.getSlickSlides();
        Assert.assertFalse("No slides found in the slick slider.", slides.isEmpty());

        String initialSlideText = homePage.getCurrentSlideText();
        homePage.waitForSlideChange(initialSlideText, 2); // Wait for the slide to change, assuming the slide changes within 2 seconds
        String newSlideText = homePage.getCurrentSlideText();
        Assert.assertNotEquals(initialSlideText, newSlideText, "Slider did not automatically move to the next slide.");

        System.out.println("----------done-------");
    }
}
