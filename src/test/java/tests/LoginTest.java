package tests;

import base.AbstractWebTest;
import org.junit.Test;
import pagesobject.features.HomePage;
import pagesobject.features.LogInPage;

import static constants.RegisterConstants.PASSWORD_REGISTER;
import static constants.RegisterConstants.PHONE_NUMBER_REGISTER;

public class LoginTest extends AbstractWebTest {
    @Test
    public void logIn_successfully() {
        HomePage homePage = new HomePage(driver);
        homePage.open()
                .clickLoginButton();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.isLogInPageDisplayed()
                .inputMobileNo(PHONE_NUMBER_REGISTER)
                .clickProceedBtn()
                .isPasswordPageDisplayed()
                .inputPassword(PASSWORD_REGISTER)
                .clickProceed()
                .isLogInSuccessful();
    }
}
