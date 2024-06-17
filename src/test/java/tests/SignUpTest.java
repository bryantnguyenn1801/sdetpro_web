package tests;

import base.AbstractWebTest;
import org.junit.Test;
import pagefactory.PageFactoryManager;
import pagesobject.features.HomePage;
import pagesobject.features.SignUpPage;
import utils.CommonUtils;

public class SignUpTest extends AbstractWebTest {
    @Test
    public void signUp_successfully() {
        HomePage homePage = PageFactoryManager.initElements(driver, HomePage.class);
        homePage.open()
                .clickLoginButton();
        SignUpPage signUpPage = PageFactoryManager.initElements(driver, SignUpPage.class);
        signUpPage.isSignUpPageDisplayed()
                .inputMobileNo("58" +CommonUtils.getRandomSevenNumbersString())
                .clickProceedBtn()
                .isOTPPageDisplayed()
                .inputPinCode("9", "9", "9", "9", "9", "9")
                .clickProceedButtonOTP()
                .isPasswordPageDisplayed()
                .inputPassword("Binh741456")
                .clickProceed()
                .isDetailsPageDisplayed()
                .inputFirstName("Cody")
                .inputLastName("Testing")
                .clickProceed()
                .isSignUpSuccessful();

    }
}
