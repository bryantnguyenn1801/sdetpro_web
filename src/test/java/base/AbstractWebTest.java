package base;

import com.epam.reportportal.annotations.Step;
import drivers.WebAppDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebTest {
    protected static WebDriver driver;

    @Before()
    @Step("Set up the WebDriver and navigate to the base URL")
    public void setUp() {
        try {
            driver = WebAppDriverManager.getDriver();
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to set up WebDriver: " + e.getMessage());
        }
    }

    @After
    @Step("Quit the WebDriver")
    public void tearDown() {
        WebAppDriverManager.quitDriver();
    }
}
