package tests;

import base.AbstractWebTest;
import constants.strings.StringConstants;
import org.junit.Test;
import pagesobject.features.*;

import static constants.RegisterConstants.*;
import static constants.strings.StringConstants.*;
import static utils.CommonUtils.*;

public class BookingVehicleTest extends AbstractWebTest {
    @Test
    public void bookVehicle() {
        HomePage homePage = new HomePage(driver);
        homePage.open()
                .clickLoginButton();
        // Login
        LogInPage logInPage = new LogInPage(driver);
        logInPage.isLogInPageDisplayed()
                .inputMobileNo(PHONE_NUMBER_REGISTER)
                .clickProceedBtn()
                .isPasswordPageDisplayed()
                .inputPassword(PASSWORD_REGISTER)
                .clickProceed();

        // Search with keyword
        homePage.enterSearchKeyword(BRANCH_SEARCH)
                .selectBranch()
                .clickSearchButton();

        // Select the first item in list after searching Vehicles
        VehicleSearchPage vehicleSearchPage = new VehicleSearchPage(driver);
        vehicleSearchPage.handleOurVehiclesDialog();
        String name = vehicleSearchPage.getVehicleNameByIndex(0);
        vehicleSearchPage.getVehicleCardByIndex(0).click();

        // Start booking vehicle
        VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage(driver);
        vehicleDetailsPage.isVehicleTitleCorrect(name)
                .clickBookVehicle();

        // Edit Driver details
        DriverDetailsPage driverDetailsPage = new DriverDetailsPage(driver);
        driverDetailsPage.isVehicleTitleCorrect(DRIVER_INFO)
                .clickFirstEditButton()
                .handleCreateProfileDialog()
                .enterFirstName(FIRST_NAME)
                .enterLastName(getRandomFiveCharsString())
                .enterEmail(EMAIL_REGISTERED)
                .clickSaveAndContinue();

        // Edit documents
        driverDetailsPage.enterIdNumber(getRandomSevenNumbersString())
                .enterIdVersionNumber(getRandomNumber(5))
                .enterAddress(getRandomFiveCharsString(5))
                .enterLicenseNumber(getRandomFiveCharsString(5) + getRandomNumber(5))
                .selectValidExpiryDate()
                .clickDocumentSaveAndContinue();

        // Go to Payment
        driverDetailsPage.clickContinueToPaymentButton();

        // Pay transaction
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.isPaymentTitleCorrect(PAYMENT)
                .isPayNowSelected()
                .enterNameOnCard(getRandomFiveCharsString(5))
                .enterCardNumber(CARD_NO)
                .enterExpiryDate(EXPIRY_DATE)
                .enterCVV(getRandomNumber(3))
                .clickPay();
    }
}
