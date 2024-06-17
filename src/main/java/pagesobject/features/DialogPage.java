package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesobject.base.AbstractPage;

import java.time.Duration;

public class DialogPage extends AbstractPage{
    @FindBy(xpath = "//h6[contains(text(),'Our Vehicles')]")
    private WebElement ourVehiclesDialog;

    @FindBy(css = "button.makestyle-ojkkaz-closeBtn")
    private WebElement closeBtn;

    public DialogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if dialog is displayed")
    public boolean isDialogDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(ourVehiclesDialog));
            return ourVehiclesDialog.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click on the close button")
    public void closeDialogIfDisplayed() {
        if (isDialogDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();

        }
    }
}
