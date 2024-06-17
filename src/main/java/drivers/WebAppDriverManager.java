package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class WebAppDriverManager {
    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "/Users/bryantnguyen1801/Documents/SDETPRO/sdetpro_web/sdetpro_web/downloadFile/chromedriver";

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("disable-features=DownloadBubble,DownloadBubbleV2");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
}

public static void quitDriver() {
    if (driver != null) {
        driver.quit();
        driver = null;
    }
}
}
