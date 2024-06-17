package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesobject.base.AbstractPage;

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
    }

    @Step("Get vehicle title")
    public String getVehicleTitle() {
        return getText(vehicleTitle);
    }

    @Step("Verify vehicle title")
    public VehicleDetailsPage isVehicleTitleCorrect(String name) {
        assertEquals(getVehicleTitle(), name, "Vehicle details not displayed correctly.");
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
