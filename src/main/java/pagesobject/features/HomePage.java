package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import java.util.List;

import static constants.strings.StringConstants.*;
import static utils.WaitUtils.*;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//h4[contains(text(),'What’s hot!?')]")
    private WebElement whatIsHotSection;

    @FindBy(xpath = "//p[contains(text(),'How Lumi can help you')]")
    private WebElement whyLumiTab;

    @FindBy(css = "#why_lumi h4")
    private WebElement whyLumiSection;

    @FindBy(xpath = "//p[contains(text(),'Speedy bookings')]")
    private WebElement speedyBookingsTab;

    @FindBy(css = "#our_step h3:nth-child(1)")
    private WebElement speedyBookingsSection;

    @FindBy(xpath = "//p[contains(text(),'Locations')]")
    private WebElement locationsTab;

    @FindBy(css = "#our_location li:nth-child(1) h4")
    private WebElement locationsSection;

    @FindBy(xpath = "//p[contains(text(),'Our app')]")
    private WebElement ourAppTab;

    @FindBy(xpath = "//h4[contains(text(),'Save time with our app')]")
    private WebElement ourAppSection;

    @FindBy(css = ".slick-slider")
    private WebElement slickSlider;

    @FindBy(css = "#whats_hot .slick-track .slick-slide")
    private List<WebElement> slickSlides;

    @FindBy(css = "input[placeholder = \"Search for a city or branch\"]")
    private WebElement searchInput;

    @FindBy(css = "#searchBlock [data-testid^=\"searchCityBranchCard_\"]")
    private List<WebElement> branches;

    @FindBy(css = "button[data-testid=\"searchButton\"]")
    private WebElement searchButton;

    @FindBy(css = "p[title=\"Sign up/Login\"]")
    private WebElement loginButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Step("Open the Home Page")
    public HomePage open() {
        driver.get("https://staging.lumirental.com/en");
        return this;
    }

    @Step("Verify the Home Page is displayed")
    public HomePage isHomePageDisplayed() {
        String actualMsg = waitForElement(whatIsHotSection).getText().trim();
        Assert.assertEquals(actualMsg, WHAT_IS_HOT_TAB);
        return this;
    }

    @Step("Enter search keyword: {keyword}")
    public HomePage enterSearchKeyword(String keyword) {
        searchInput.sendKeys(keyword);
        click(searchInput);
        return this;
    }

    @Step("Select Branch")
    public HomePage selectBranch() {
        click(branches.get(1));
        return this;
    }

    @Step("Click the Search button")
    public HomePage clickSearchButton() {
        click(searchButton);
        return this;
    }

    @Step("Click the Login button")
    public HomePage clickLoginButton() {
        waitForElement(loginButton);
        click(loginButton);
        return this;
    }

    @Step("Check if 'What’s hot!?' tab is displayed")
    public boolean isWhatsHotTabDisplayed() {
        return whatIsHotSection.isDisplayed();
    }

    @Step("Click on 'What’s hot!?' tab")
    public void clickWhatsHotTab() {
        waitForElementClickable(whatIsHotSection);
        click(whatIsHotSection);
    }

    @Step("Get the list of slick slides")
    public List<WebElement> getSlickSlides() {
        return slickSlides;
    }

    @Step("Wait for the slide to change")
    public void waitForSlideChange(String previousSlideText, int timeoutInSeconds) {
        waitForTextPresentInElement(slickSlider, previousSlideText, timeoutInSeconds);
    }

    @Step("Get the text of the current slide")
    public String getCurrentSlideText() {
        for (WebElement slide : slickSlides) {
            if (slide.getAttribute("aria-hidden").equals("false")) {
                return slide.getText();
            }
        }
        return null;
    }

    @Step("Check if slick slider is displayed")
    public boolean isSlickSliderDisplayed() {
        return slickSlider.isDisplayed();
    }

    @Step("Click on 'How Lumi can help you' tab")
    public void clickHowToHelpTab() {
        waitForElementClickable(whyLumiTab);
        click(whyLumiTab);
    }

    @Step("Check if 'How Lumi can help you' tab is displayed")
    public boolean isHowToHelpTabDisplayed() {
        return whyLumiTab.isDisplayed();
    }

    @Step("Verify the 'How Lumi can help you' section is displayed")
    public HomePage isHowToHelpSectionDisplayed() {
        String actualMsg = waitForElement(whyLumiSection).getText().trim();
        Assert.assertEquals(actualMsg, HOW_LUMI_HELP_YOU_TAB);
        return this;
    }

    @Step("Click on 'Speedy bookings' tab")
    public void clickSpeedyBookingsTab() {
        waitForElementClickable(speedyBookingsTab);
        click(speedyBookingsTab);
    }

    @Step("Check if 'Speedy bookings' tab is displayed")
    public boolean isSpeedyBookingsTabDisplayed() {
        return speedyBookingsTab.isDisplayed();
    }

    @Step("Verify the 'Speedy bookings' section is displayed")
    public HomePage isSpeedyBookingsSectionDisplayed() {
        String actualMsg = waitForElement(speedyBookingsSection).getText().trim();
        Assert.assertEquals(actualMsg, SPEEDY_BOOKINGS_TAB);
        return this;
    }

    @Step("Click on 'Locations' tab")
    public void clickLocationsTab() {
        waitForElementClickable(locationsTab);
        click(locationsTab);
    }

    @Step("Check if 'Locations' tab is displayed")
    public boolean isLocationsTabDisplayed() {
        return locationsTab.isDisplayed();
    }

    @Step("Verify the 'Locations' section is displayed")
    public HomePage isLocationsSectionDisplayed() {
        String actualMsg = waitForElement(locationsSection).getText().trim();
        Assert.assertEquals(actualMsg, LOCATIONS_TAB);
        return this;
    }

    @Step("Click on 'Our app' tab")
    public void clickOurAppTab() {
        waitForElementClickable(ourAppTab);
        click(ourAppTab);
    }

    @Step("Check if 'Our app' tab is displayed")
    public boolean isOurAppTabDisplayed() {
        return ourAppTab.isDisplayed();
    }

    @Step("Verify the 'Our app' section is displayed")
    public HomePage isOurAppSectionDisplayed() {
        String actualMsg = waitForElement(ourAppSection).getText().trim();
        Assert.assertEquals(actualMsg, OUR_APP_TAB);
        return this;
    }

}
