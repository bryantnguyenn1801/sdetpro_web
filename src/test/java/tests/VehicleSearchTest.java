package tests;

import base.AbstractWebTest;
import org.junit.Test;
import pagesobject.features.HomePage;
import pagesobject.features.VehicleSearchPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehicleSearchTest extends AbstractWebTest {
//    @Test
//    public void searchForVehicleByCity() {
//        HomePage homePage = new HomePage(driver);
//        homePage.open()
//                .enterSearchKeyword("New York")
//                .clickSearchButton();
//
//        VehicleSearchPage vehicleSearchPage = new VehicleSearchPage(driver);
//        assertFalse(vehicleSearchPage.getVehicleCards().isEmpty(), "No vehicles found for the specified city.");
//    }
//
//    @Test
//    public void filterVehiclesByType() {
//        HomePage homePage = new HomePage(driver);
//        homePage.open()
//                .enterSearchKeyword("New York")
//                .clickSearchButton();
//
//        VehicleSearchPage vehicleSearchPage = new VehicleSearchPage(driver);
//        vehicleSearchPage.filterByVehicleType("SUV");
//        assertFalse(vehicleSearchPage.getVehicleCards().isEmpty(), "No SUVs found for the specified filter.");
//    }
//
//    @Test
//    public void sortVehiclesByPrice() {
//        HomePage homePage = new HomePage(driver);
//        homePage.open()
//                .enterSearchKeyword("New York")
//                .clickSearchButton();
//
//        VehicleSearchPage vehicleSearchPage = new VehicleSearchPage(driver);
//        vehicleSearchPage.sortByPrice("asc");
//        // Additional logic to verify sorting can be added here
//        assertFalse(vehicleSearchPage.getVehicleCards().isEmpty(), "No vehicles found for the specified sort order.");
//    }
}
