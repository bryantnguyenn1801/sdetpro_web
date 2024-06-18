package base;

import com.epam.reportportal.annotations.Step;
import drivers.WebAppDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static constants.strings.Messages.FAIL_TO_SETUP_WEBDRIVER;

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
            throw new RuntimeException(FAIL_TO_SETUP_WEBDRIVER + e.getMessage());
        }
    }

    @After
    @Step("Quit the WebDriver")
    public void tearDown() {
        WebAppDriverManager.quitDriver();
    }
}
