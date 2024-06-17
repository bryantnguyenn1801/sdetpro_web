package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesobject.base.AbstractPage;

import java.time.Duration;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//h4[contains(text(),'What’s hot!?')]")
    private WebElement whatIsHotTab;

    @FindBy(xpath = "//p[contains(text(),'How Lumi can help you')]")
    private WebElement howToHelpTab;

    @FindBy(xpath = "//p[contains(text(),'Speedy bookings')]")
    private WebElement speedyBookingsTab;

    @FindBy(xpath = "//p[contains(text(),'Locations')]")
    private WebElement locationsTab;

    @FindBy(xpath = "//p[contains(text(),'Our app')]")
    private WebElement ourAppTab;

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
        String actualMsg = wait.until(ExpectedConditions.visibilityOf(whatIsHotTab)).getText().trim();
        Assert.assertEquals(actualMsg, "What’s hot!?");
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
        branches.get(1).click();
        return this;
    }

    @Step("Click the Search button")
    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Click the Login button")
    public HomePage clickLoginButton() {
        waitForVisibility(loginButton);
        loginButton.click();
        return this;
    }

    @Step("Check if 'What’s hot!?' tab is displayed")
    public boolean isWhatsHotTabDisplayed() {
        return whatIsHotTab.isDisplayed();
    }

    @Step("Click on 'What’s hot!?' tab")
    public void clickWhatsHotTab() {
        waitForClickable(whatIsHotTab);
        whatIsHotTab.click();
    }

    @Step("Get the list of slick slides")
    public List<WebElement> getSlickSlides() {
        return slickSlides;
    }

    @Step("Wait for the slide to change")
    public void waitForSlideChange(String previousSlideText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(slickSlider, previousSlideText)));
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

    @Step("Check if 'How Lumi can help you' tab is displayed")
    public boolean isHowToHelpTabDisplayed() {
        return howToHelpTab.isDisplayed();
    }

    @Step("Click on 'How Lumi can help you' tab")
    public void clickHowToHelpTab() {
        waitForClickable(howToHelpTab);
        howToHelpTab.click();
    }

    @Step("Check if 'Speedy bookings' tab is displayed")
    public boolean isSpeedyBookingsTabDisplayed() {
        return speedyBookingsTab.isDisplayed();
    }

    @Step("Click on 'Speedy bookings' tab")
    public void clickSpeedyBookingsTab() {
        waitForClickable(speedyBookingsTab);
        speedyBookingsTab.click();
    }

    @Step("Check if 'Locations' tab is displayed")
    public boolean isLocationsTabDisplayed() {
        return locationsTab.isDisplayed();
    }

    @Step("Click on 'Locations' tab")
    public void clickLocationsTab() {
        waitForClickable(locationsTab);
        locationsTab.click();
    }

    @Step("Check if 'Our app' tab is displayed")
    public boolean isOurAppTabDisplayed() {
        return ourAppTab.isDisplayed();
    }

    @Step("Click on 'Our app' tab")
    public void clickOurAppTab() {
        waitForClickable(ourAppTab);
        ourAppTab.click();
    }

}
