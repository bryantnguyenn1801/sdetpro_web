package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import static constants.strings.Messages.VEHICLE_DETAILS_NOT_SHOWED;
import static org.junit.Assert.assertEquals;

public class VehicleDetailsPage extends AbstractPage {
    @FindBy(css = "[data-testid=\"bookingDetailsSection\"] [data-testid=\"fleetDetailsFleetName\"]")
    private WebElement vehicleTitle;

    @FindBy(css = "button[data-testid='addToFavorites']")
    private WebElement addToFavoritesButton;

    @FindBy(css = "button[data-testid=\"fleetDetialsContinueBtn\"]")
    private WebElement bookVehicleButton;

    public VehicleDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Step("Verify vehicle title")
    public VehicleDetailsPage isVehicleTitleCorrect(String name) {
        assertEquals(VEHICLE_DETAILS_NOT_SHOWED, name, getText(vehicleTitle));
        return this;
    }

    @Step("Click add to favorites button")
    public VehicleDetailsPage clickAddToFavorites() {
        click(addToFavoritesButton);
        return this;
    }

    @Step("Click book vehicle button")
    public VehicleDetailsPage clickBookVehicle() {
        click(bookVehicleButton);
        return this;
    }
}
