package pagesobject.features;


import com.epam.reportportal.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import static constants.strings.StringConstants.*;
import static utils.WaitUtils.waitForElement;
import static utils.WaitUtils.waitForElementClickable;

public class LogInPage extends AbstractPage {
    @FindBy(xpath = "//h6[contains(text(),'Create an account or sign in')]")
    private WebElement logInPageTitle;

    @FindBy(css = "[data-testid=\"createAccountMobileNumber\"] input")
    private WebElement mobileNumberField;

    @FindBy(css = "[data-testid=\"createAccountProceedBtn\"]")
    private WebElement proceedBtn;

    @FindBy(xpath = "//h6[contains(text(),'Enter your password')]")
    private WebElement passwordPageTitle;

    @FindBy(css = "input[placeholder=\"Password\"]")
    private WebElement passwordField;

    @FindBy(css = "button[type=\"submit\"")
    private WebElement proceedBtnPassword;

    @FindBy(css = "#demo-positioned-button")
    private WebElement viewMyAccountBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Input mobile number")
    public LogInPage inputMobileNo(String mobileNo) {
        type(mobileNumberField, mobileNo);
        return this;
    }

    @Step("Click Proceed button on mobile input screen")
    public LogInPage clickProceedBtn() {
        waitForElementClickable(proceedBtn);
        click(proceedBtn);
        return this;
    }


    @Step("Input password")
    public LogInPage inputPassword(String passWord) {
        type(passwordField, passWord);
        return this;
    }

    @Step("Click Proceed button on Password input screen")
    public LogInPage clickProceed() {
        waitForElementClickable(proceedBtnPassword);
        click(proceedBtnPassword);
        return this;
    }

    @Step("Verify Sign Up Page is Displayed")
    public LogInPage isLogInPageDisplayed() {
        String actualMsg = waitForElement(logInPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, LOG_IN_PAGE_TITLE);
        return this;
    }

    @Step("Verify Create Password Page is Displayed")
    public LogInPage isPasswordPageDisplayed() {
        String actualMsg = waitForElement(passwordPageTitle).getText().trim();
        Assert.assertEquals(actualMsg, LOG_IN_PASSWORD_PAGE_TITLE);
        return this;
    }

    @Step("Verify sign up successful")
    public HomePage isLogInSuccessful() {
        String actualMsg = waitForElement(viewMyAccountBtn).getText().trim();
        Assert.assertEquals(actualMsg, MY_ACCOUNT_BTN_TXT);
        return new HomePage(driver);
    }
}