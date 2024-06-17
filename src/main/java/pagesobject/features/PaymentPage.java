package pagesobject.features;

//import com.epam.reportportal.annotations.Step;
import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesobject.base.AbstractPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentPage extends AbstractPage {
    @FindBy(xpath = "//h6[contains(text(),'Payment')]")
    private WebElement paymentTitle;

    @FindBy(css = ".PrivateSwitchBase-input[value=\"CHECKOUT\"]")
    private WebElement payNowPriceRadioBtn;

    @FindBy(css = "[data-testid=\"paymentDetailPayCardName\"] input")
    private WebElement nameOnCard;

    @FindBy(css = "input[name=\"cardnumber\"]")
    private WebElement cardNumber;

    @FindBy(css = "input[name=\"exp-date\"]")
    private WebElement expiryDate;

    @FindBy(css = "input[name=\"cvc\"]")
    private WebElement inputCvv;

    @FindBy(css = "button[data-testid=\"paymentDetailPayNowBtn\"]")
    private WebElement payBtn;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get driver details title")
    public String getPaymentTitle() {
        return getText(paymentTitle);
    }

    @Step("Verify driver details title")
    public PaymentPage isPaymentTitleCorrect(String title) {
        assertEquals(getPaymentTitle(), title, "Payment page not displayed correctly.");
        return this;
    }

    @Step("Verify Pay Now Button")
    public PaymentPage isPayNowSelected() {
        assertTrue("Payment page not displayed correctly.", payNowPriceRadioBtn.isSelected());
        return this;
    }

    @Step("Enter name on card")
    public PaymentPage enterNameOnCard(String nameOnCardTxt) {
        type(nameOnCard, nameOnCardTxt);
        return this;
    }

    @Step("Enter card number")
    public PaymentPage enterCardNumber(String cardNo) {
        type(cardNumber, cardNo);
        return this;
    }

    @Step("Enter expiry date")
    public PaymentPage enterExpiryDate(String expDate) {
        type(expiryDate, expDate);
        return this;
    }

    @Step("Enter CVV")
    public PaymentPage enterCVV(String cvvNumber) {
        type(inputCvv, cvvNumber);
        return this;
    }

    @Step("Click Pay Button")
    public PaymentPage clickPay() {
        click(payBtn);
        return this;
    }


}
