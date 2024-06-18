package pagesobject.features;


import com.epam.reportportal.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import java.time.Duration;
import java.util.List;

import static constants.strings.StringConstants.*;
import static utils.WaitUtils.waitForElement;
import static utils.WaitUtils.waitForElementClickable;

public class SignUpPage extends AbstractPage {
    @FindBy(xpath = "//h6[contains(text(),'Create an account or sign in')]")
    private WebElement signUpPageTitle;

    @FindBy(css = "[data-testid=\"createAccountMobileNumber\"] input")
    private WebElement mobileNumberField;

    @FindBy(css = "[data-testid=\"createAccountProceedBtn\"]")
    private WebElement proceedBtn;

    @FindBy(xpath = "//h6[contains(text(),'Verify number')]")
    private WebElement otpPageTitle;

    @FindBy(css = "input")
    private List<WebElement> pinCodeInput;

    @FindBy(css = ".MuiButton-contained")
    private WebElement proceedButtonOTP;

    @FindBy(xpath = "//h6[contains(text(),'Create your password')]")
    private WebElement passwordPageTitle;

    @FindBy(css = "input[placeholder=\"Password\"]")
    private WebElement passwordField;

    @FindBy(css = "button[type=\"submit\"")
    private WebElement proceedBtnPassword;

    @FindBy(xpath = "//h6[contains(text(),'One last step')]")
    private WebElement detailsPageTitle;

    @FindBy(css = "input[name=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[name=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(css = "#demo-positioned-button")
    private WebElement viewMyAccountBtn;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Input mobile number")
    public SignUpPage inputMobileNo(String mobileNo) {
        type(mobileNumberField, mobileNo);
        return this;
    }

    @Step("Click Proceed button on mobile input screen")
    public SignUpPage clickProceedBtn() {
        waitForElementClickable(proceedBtn);
        click(proceedBtn);
        return this;
    }

    @Step("Input {9} to [Pin code]")
    public SignUpPage inputPinCode(String pinNumbers) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        String[] pinArray = pinNumbers.split("");
        for (int i = 0; i < pinCodeInput.size() ; i++) {
            type(pinCodeInput.get(i), pinArray[i]);
        }
        return this;
    }

    @Step("Click Proceed button on OTP input screen")
    public SignUpPage clickProceedButtonOTP() {
        waitForElementClickable(proceedButtonOTP);
        click(proceedButtonOTP);
        return this;
    }

    @Step("Input password")
    public SignUpPage inputPassword(String passWord) {
        type(passwordField, passWord);
        return this;
    }

    @Step("Click Proceed button on Password input screen")
    public SignUpPage clickProceed() {
        waitForElementClickable(proceedBtnPassword);
        click(proceedBtnPassword);
        return this;
    }

    @Step("Verify Sign Up Page is Displayed")
    public SignUpPage isSignUpPageDisplayed() {
        String actualMsg = waitForElement(signUpPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, SIGN_UP_PAGE_TITLE);
        return this;
    }

    @Step("Verify Input OTP Page is Displayed")
    public SignUpPage isOTPPageDisplayed() {
        String actualMsg = waitForElement(otpPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, OTP_PAGE_TITLE);
        return this;
    }

    @Step("Verify Create Password Page is Displayed")
    public SignUpPage isPasswordPageDisplayed() {
        String actualMsg = waitForElement(passwordPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, SIGN_UP_PASSWORD_PAGE_TITLE);
        return this;
    }

    @Step("Verify Personal Details Page is Displayed")
    public SignUpPage isDetailsPageDisplayed() {
        String actualMsg = waitForElement(detailsPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, DETAILS_PAGE_TITLE);
        return this;
    }

    @Step("Input First Name")
    public SignUpPage inputFirstName(String firstName) {
        type(firstNameField, firstName);
        return this;
    }

    @Step("Input Last Name")
    public SignUpPage inputLastName(String lastName) {
        type(lastNameField, lastName);
        return this;
    }

    @Step("Verify sign up successful")
    public HomePage isSignUpSuccessful() {
        String actualMsg = waitForElement(viewMyAccountBtn).getText().trim();
        Assert.assertEquals(actualMsg, MY_ACCOUNT_BTN_TXT);
        return new HomePage(driver);
    }
}