package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import static utils.WaitUtils.waitForElement;
import static utils.WaitUtils.waitForElementClickable;

public class DialogPage extends AbstractPage{
    @FindBy(xpath = "[data-testid=\"fleetListingOurCarDailog\"]")
    private WebElement ourVehiclesDialog;

    @FindBy(css = "[data-testid=\"fleetListingOurCarDailog\"] button")
    private WebElement closeBtn;

    @FindBy(css = "button[data-testid=\"createProfileBtn\"]")
    private WebElement createProfileBtn;

    public DialogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Check if dialog is displayed")
    public boolean isDialogDisplayed() {
        try {
            waitForElement(closeBtn);
            return closeBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click on the close button")
    public void closeDialogIfDisplayed() {
        if (isDialogDisplayed()) {
            waitForElementClickable(closeBtn).click();
        }
    }

    @Step("Check if create profile dialog is displayed")
    public boolean isCreateProfileDialogDisplayed() {
        try {
            waitForElement(createProfileBtn);
            return createProfileBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click on the close button")
    public void clickDialogIfDisplayed() {
        if (isCreateProfileDialogDisplayed()) {
            waitForElementClickable(createProfileBtn).click();
        }
    }
}
