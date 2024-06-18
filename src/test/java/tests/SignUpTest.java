package tests;

import base.AbstractWebTest;
import org.junit.Test;
import pagesobject.features.HomePage;
import pagesobject.features.SignUpPage;

import static constants.RegisterConstants.*;

public class SignUpTest extends AbstractWebTest {
    @Test
    public void signUp_successfully() {
        HomePage homePage = new HomePage(driver);
        homePage.open()
                .clickLoginButton();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.isSignUpPageDisplayed()
                .inputMobileNo(PHONE_NUMBER)
                .clickProceedBtn()
                .isOTPPageDisplayed()
                .inputPinCode(PIN_NUMBER)
                .clickProceedButtonOTP()
                .isPasswordPageDisplayed()
                .inputPassword(PASSWORD)
                .clickProceed()
                .isDetailsPageDisplayed()
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .clickProceed()
                .isSignUpSuccessful();
    }
}
