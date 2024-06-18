package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;
import utils.DateUtils;

import java.util.List;

import static constants.strings.Messages.DRIVER_DETAILS_NOT_SHOWED;
import static org.junit.Assert.assertEquals;
import static utils.WaitUtils.waitForElement;

public class DriverDetailsPage extends AbstractPage {
    @FindBy(xpath = "//span[contains(text(),'Driver information')]")
    private WebElement driverDetailsTitle;

    @FindBy(css = "button.makestyle-1elyv5v-editBtn")
    private List<WebElement> editButtons;

    @FindBy(css = "[data-testid=\"driverInfoFirstName\"] input")
    private WebElement firstName;

    @FindBy(css = "[data-testid=\"driverInfoLastName\"] input")
    private WebElement lastName;

    @FindBy(css = "[data-testid=\"driverInfoEmail\"] input")
    private WebElement inputEmail;

    @FindBy(css = "[data-testid=\"driverInfoMobileNumber\"] input")
    private WebElement inputMobileNo;

    @FindBy(css = "[data-testid=\"driverInfoContinuePaymentBtn\"]")
    private WebElement saveAndContinueBtn;

    @FindBy(css = "[data-testid=\"driverDocumentIdNumber\"] input")
    private WebElement idNumber;

    @FindBy(css = "[data-testid=\"driverDocumentIdVersionNumber\"] input")
    private WebElement idVersionNumber;

    @FindBy(css = "[data-testid=\"driverDocumentAddress\"] input")
    private WebElement address;

    @FindBy(css = "[data-testid=\"driverDocumentLicenseNumber\"] input")
    private WebElement licenseNumber;

    @FindBy(css = "button[data-testid=\"driverDocumentSaveBtn\"]")
    private WebElement documentSaveAndContinueBtn;

    @FindBy(xpath = "//h6[contains(text(),'Expiry date')]")
    private WebElement expiryDateSection;

    @FindBy(css = "[data-testid=\"driverDocumentExpiryDay\"] #day-select")
    private WebElement expiryDayDropdown;

    @FindBy(css = "[data-testid=\"driverDocumentExpiryMonth\"] input")
    private WebElement expiryMonthDropdown;

    @FindBy(css = "[data-testid=\"driverDocumentExpiryYear\"] input")
    private WebElement expiryYearDropdown;

    @FindBy(css = "ul[role=\"listbox\"] li")
    private List<WebElement> allItemsDropDown;

    @FindBy(css = "button[data-testid=\"driverDetailsContinueToPaymentBtn\"]")
    private WebElement continueToPaymentBtn;

    private static final String EXPIRY_DAY_DROPDOWN = "[data-testid='driverDocumentExpiryDay'] input";
    private static final String EXPIRY_MONTH_DROPDOWN = "[data-testid='driverDocumentExpiryMonth'] input";
    private static final String EXPIRY_YEAR_DROPDOWN = "[data-testid='driverDocumentExpiryYear'] input";
    private static final String ALL_ITEM__DROPDOWN = "ul[role='listbox'] li";


    public DriverDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Step("Get driver details title")
    public String getDriverDetailsTitle() {
        return getText(driverDetailsTitle);
    }

    @Step("Verify driver details title")
    public DriverDetailsPage isVehicleTitleCorrect(String title) {
        assertEquals(DRIVER_DETAILS_NOT_SHOWED, title, getDriverDetailsTitle());
        return this;
    }

    @Step("Get list of edit buttons")
    public List<WebElement> getEditButtons() {
        return editButtons;
    }

    @Step("Click the first edit button")
    public DriverDetailsPage clickFirstEditButton() {
        if (!editButtons.isEmpty()) {
            clickToElementByJavascript(editButtons.get(0));
        }
        return this;
    }

    @Step("Enter first name: {0}")
    public DriverDetailsPage enterFirstName(String firstNameText) {
        clearTextElementWithKeys(firstName);
        type(firstName, firstNameText);
        return this;
    }

    @Step("Enter last name: {0}")
    public DriverDetailsPage enterLastName(String lastNameText) {
        waitForElement(lastName);
        clearTextElementWithKeys(lastName);
        type(lastName, lastNameText);
        return this;
    }

    @Step("Enter email: {0}")
    public DriverDetailsPage enterEmail(String email) {
        waitForElement(inputEmail);
        clearTextElementWithKeys(inputEmail);
        type(inputEmail, email);
        return this;
    }

    @Step("Click Save and Continue button")
    public DriverDetailsPage clickSaveAndContinue() {
        click(saveAndContinueBtn);
        return this;
    }

    @Step("Enter ID number: {0}")
    public DriverDetailsPage enterIdNumber(String idNum) {
        scrollToElement(idNumber);
        waitForElement(idNumber);
        clearTextElementWithKeys(idNumber);
        type(idNumber, idNum);
        return this;
    }

    @Step("Enter ID version number: {0}")
    public DriverDetailsPage enterIdVersionNumber(String idVerNum) {
        scrollToElement(idVersionNumber);
        waitForElement(idVersionNumber);
        clearTextElementWithKeys(idVersionNumber);
        type(idVersionNumber, idVerNum);
        return this;
    }

    @Step("Enter address: {0}")
    public DriverDetailsPage enterAddress(String addr) {
        scrollToElement(address);
        waitForElement(address);
        clearTextElementWithKeys(address);
        type(address, addr);
        return this;
    }

    @Step("Enter license number: {0}")
    public DriverDetailsPage enterLicenseNumber(String licenseNum) {
        scrollToElement(licenseNumber);
        waitForElement(licenseNumber);
        clearTextElementWithKeys(licenseNumber);
        type(licenseNumber, licenseNum);
        return this;
    }

    @Step("Click Document Save and Continue button")
    public DriverDetailsPage clickDocumentSaveAndContinue() {
        click(documentSaveAndContinueBtn);
        return this;
    }


    @Step("Select valid expiry date")
    public DriverDetailsPage selectValidExpiryDate() {
        String[] expiryDate = DateUtils.getFormattedExpiryDate();
        String expiryDay = expiryDate[0];
        String expiryMonth = expiryDate[1];
        String expiryYear = expiryDate[2];
        if (expiryDateSection.isDisplayed()) {
            clickToElementByJavascript(expiryDayDropdown);
            try {
                selectItemInCustomDropdown(EXPIRY_DAY_DROPDOWN, ALL_ITEM__DROPDOWN, expiryDay);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            clickToElementByJavascript(expiryMonthDropdown);
            try {
                selectItemInCustomDropdown(EXPIRY_MONTH_DROPDOWN, ALL_ITEM__DROPDOWN, expiryMonth);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            clickToElementByJavascript(expiryYearDropdown);
            try {
                selectItemInCustomDropdown(EXPIRY_YEAR_DROPDOWN, ALL_ITEM__DROPDOWN, expiryYear);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return this;
        }


        return null;
    }

    @Step("Click the continue button")
    public DriverDetailsPage clickContinueToPaymentButton() {
        click(continueToPaymentBtn);
        return this;
    }

    @Step("Handle dialog if displayed")
    public DriverDetailsPage handleCreateProfileDialog() {
        DialogPage dialogPage = new DialogPage(driver);
        dialogPage.clickDialogIfDisplayed();
        return this;
    }
}
