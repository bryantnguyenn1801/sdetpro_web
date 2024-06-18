package pagesobject.features;

import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesobject.base.AbstractPage;

import java.util.List;

public class VehicleSearchPage extends AbstractPage {
    public static final By hideBackdropBy = By.cssSelector("[data-testid='hideBackdrop']");

    @FindBy(css = "input[placeholder='Search for a city or branch']")
    private WebElement searchInput;

    @FindBy(css = "button[data-testid='searchButton']")
    private WebElement searchButton;

    @FindBy(css = "[data-testid^='fleetListingFleetCard_']")
    private List<WebElement> vehicleCards;

    @FindBy(css = "select[data-testid='vehicleTypeFilter']")
    private WebElement vehicleTypeFilter;

    @FindBy(css = "select[data-testid='priceSort']")
    private WebElement priceSort;

    public VehicleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Step("Enter search keyword: {keyword}")
    public VehicleSearchPage enterSearchKeyword(String keyword) {
        type(searchInput, keyword);
        return this;
    }

    @Step("Click on the search button")
    public VehicleSearchPage clickSearchButton() {
        click(searchButton);
        return this;
    }

    @Step("Get list of vehicle cards")
    public List<WebElement> getVehicleCards() {
        return vehicleCards;
    }

    @Step("Get vehicle card by index: {index}")
    public WebElement getVehicleCardByIndex(int index) {
        String dataTestId = "fleetListingFleetCard_" + (index + 1);
        return driver.findElement(By.cssSelector(String.format("[data-testid='%s']", dataTestId)));
    }

    @Step("Get vehicle name by index: {index}")
    public String getVehicleNameByIndex(int index) {
        WebElement vehicleCard = getVehicleCardByIndex(index);
        WebElement vehicleNameElement = vehicleCard.findElement(By.cssSelector("[data-testid='fleetListingFleetName']"));
        return vehicleNameElement.getText();
    }

    @Step("Filter by vehicle type: {type}")
    public VehicleSearchPage filterByVehicleType(String type) {
        selectItemInDropdown(vehicleTypeFilter, type);
        return this;
    }

    @Step("Sort by price: {sortOrder}")
    public VehicleSearchPage sortByPrice(String sortOrder) {
        selectItemInDropdown(priceSort, sortOrder);
        return this;
    }

    @Step("Handle dialog if displayed")
    public VehicleSearchPage handleOurVehiclesDialog() {
        DialogPage dialogPage = new DialogPage(driver);
        dialogPage.closeDialogIfDisplayed();
        return this;
    }
}
