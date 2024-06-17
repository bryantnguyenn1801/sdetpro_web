package pagesobject.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectItemInDropdown(WebElement element, String expectedValueInDropdown) {
        waitForVisibility(element);
        Select select = new Select(element);
        select.selectByVisibleText(expectedValueInDropdown);
    }

    public void clickToElementByJavascript(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(locator));
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public WebElement waitForElementVisible(WebElement element, Duration timeout) {
        WebDriverWait waitExplicit = new WebDriverWait(this.driver, timeout);
        try {
            return waitExplicit.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception var3) {
            return null;
        }
    }
}
