package tests;

import base.AbstractWebTest;
import org.junit.Test;
import pagefactory.PageFactoryManager;
import pagesobject.features.*;

import static utils.CommonUtils.*;

public class VehicleDetailsTest extends AbstractWebTest {
    @Test
    public void bookVehicle() {
        HomePage homePage = PageFactoryManager.initElements(driver, HomePage.class);
        homePage.open()
                .enterSearchKeyword("Riyadh")
                .selectBranch()
                .clickSearchButton();

        // Select the first item in list after searching Vehicles
        VehicleSearchPage vehicleSearchPage = PageFactoryManager.initElements(driver, VehicleSearchPage.class);
        vehicleSearchPage.handleOurVehiclesDialog();
        String name = vehicleSearchPage.getVehicleNameByIndex(0);
        vehicleSearchPage.getVehicleCardByIndex(0).click();

        // Start booking vehicle
        VehicleDetailsPage vehicleDetailsPage = PageFactoryManager.initElements(driver, VehicleDetailsPage.class);
        vehicleDetailsPage.isVehicleTitleCorrect(name)
                .clickBookVehicle();

        // Edit Driver details
        DriverDetailsPage driverDetailsPage = PageFactoryManager.initElements(driver, DriverDetailsPage.class);
        driverDetailsPage.isVehicleTitleCorrect("Driver information")
                .clickFirstEditButton()
                .enterFirstName("Bryant")
                .enterLastName(getRandomFiveCharsString())
                .enterEmail(getRandomFiveCharsString() + getRandomNumber(2) + "@gmail.com")
                .clickSaveAndContinue();

        // Edit documents
        driverDetailsPage.enterIdNumber(getRandomSevenNumbersString())
                .enterIdVersionNumber(getRandomNumber(5))
                .enterAddress(getRandomFiveCharsString(5))
                .enterLicenseNumber(getRandomFiveCharsString(5) + getRandomNumber(5))
                .clickDocumentSaveAndContinue()
                .selectValidExpiryDate();

        // Go to Payment
        driverDetailsPage.clickContinueToPaymentButton();

        // Pay transaction
        PaymentPage paymentPage = PageFactoryManager.initElements(driver, PaymentPage.class);
        paymentPage.isPaymentTitleCorrect("Payment")
                .isPayNowSelected()
                .enterNameOnCard(getRandomFiveCharsString(5))
                .enterCardNumber("456" + getRandomNumber(10))
                .enterExpiryDate("1229")
                .enterCVV(getRandomNumber(3))
                .clickPay();

    }
}
