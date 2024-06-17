package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pagesobject.base.AbstractPage;
import utils.DateUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DriverDetailsPage extends AbstractPage {
    @FindBy(xpath = "//span[contains(text(),'Driver information')]")
    private WebElement driverDetailsTitle;

    @FindBy(css = "button img[alt=\"Edit Icon\"]")
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

    @FindBy(css = "[data-testid=\"driverDocumentIdNumber\"]")
    private WebElement idNumber;

    @FindBy(css = "[data-testid=\"driverDocumentIdVersionNumber\"]")
    private WebElement idVersionNumber;

    @FindBy(css = "[data-testid=\"driverDocumentAddress\"]")
    private WebElement address;

    @FindBy(css = "[data-testid=\"driverDocumentLicenseNumber\"]")
    private WebElement licenseNumber;

    @FindBy(css = "button[data-testid=\"driverDocumentSaveBtn\"]")
    private WebElement documentSaveAndContinueBtn;

    @FindBy(css = "select[data-testid='expiryDay']")
    private WebElement expiryDayDropdown;

    @FindBy(css = "select[data-testid='expiryMonth']")
    private WebElement expiryMonthDropdown;

    @FindBy(css = "select[data-testid='expiryYear']")
    private WebElement expiryYearDropdown;

    @FindBy(css = "button[data-testid=\"driverDetailsContinueToPaymentBtn\"]")
    private WebElement continueToPaymentBtn;

    public DriverDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get driver details title")
    public String getDriverDetailsTitle() {
        return getText(driverDetailsTitle);
    }

    @Step("Verify driver details title")
    public DriverDetailsPage isVehicleTitleCorrect(String title) {
        assertEquals(getDriverDetailsTitle(), title, "Driver details not displayed correctly.");
        return this;
    }

    @Step("Get list of edit buttons")
    public List<WebElement> getEditButtons() {
        return editButtons;
    }

    @Step("Click the first edit button")
    public DriverDetailsPage clickFirstEditButton() {
        if (!editButtons.isEmpty()) {
            click(editButtons.get(0));
        }
        return this;
    }

    @Step("Enter first name: {0}")
    public DriverDetailsPage enterFirstName(String firstNameText) {
        type(firstName, firstNameText);
        return this;
    }

    @Step("Enter last name: {0}")
    public DriverDetailsPage enterLastName(String lastNameText) {
        type(lastName, lastNameText);
        return this;
    }

    @Step("Enter email: {0}")
    public DriverDetailsPage enterEmail(String email) {
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
        type(idNumber, idNum);
        return this;
    }

    @Step("Enter ID version number: {0}")
    public DriverDetailsPage enterIdVersionNumber(String idVerNum) {
        type(idVersionNumber, idVerNum);
        return this;
    }

    @Step("Enter address: {0}")
    public DriverDetailsPage enterAddress(String addr) {
        type(address, addr);
        return this;
    }

    @Step("Enter license number: {0}")
    public DriverDetailsPage enterLicenseNumber(String licenseNum) {
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

        new Select(expiryDayDropdown).selectByVisibleText(expiryDay);
        new Select(expiryMonthDropdown).selectByVisibleText(expiryMonth);
        new Select(expiryYearDropdown).selectByVisibleText(expiryYear);

        return this;
    }

    @Step("Click the continue button")
    public DriverDetailsPage clickContinueToPaymentButton() {
        click(continueToPaymentBtn);
        return this;
    }
}
