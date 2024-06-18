package utils;

import drivers.WebAppDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static WebElement waitForElement(WebElement el){
        try {
            WebDriverWait wait = new WebDriverWait(WebAppDriverManager.getDriver(), Duration.ofSeconds(30));
            wait.ignoring(StaleElementReferenceException.class);
            return wait.until(ExpectedConditions.visibilityOf(el));
        } catch (TimeoutException toe) {
            throw new AssertionError("Element not found within the specified timeout: " + toe.getMessage());
        }
    }

    public static boolean isElementDisplayed(WebElement element){
        boolean elementDisplayed = false;
        try{
            if (((WebElement)element).isDisplayed()){
                elementDisplayed = true;
            }
        } catch (Exception e){
            return false;
        }
        return elementDisplayed;
    }

    public static WebElement waitForElementCustomTimeout(WebElement el,
                                                         Integer timeoutSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(WebAppDriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(el));
        } catch (TimeoutException toe){
            throw new AssertionError(toe.getMessage());
        }
        return el;
    }

    public static WebElement waitForElementClickable(WebElement el){
        try{
            WebDriverWait wait = new WebDriverWait(WebAppDriverManager.getDriver(), Duration.ofSeconds(35));
            wait.until(ExpectedConditions.elementToBeClickable(el));
        } catch (TimeoutException toe){
            throw new AssertionError(toe.getMessage());
        }
        return el;
    }

    public static boolean waitForTextPresentInElement(WebElement el, String text, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(WebAppDriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.textToBePresentInElement(el, text));
        } catch (NoSuchElementException nse){
            return false;
        } catch (TimeoutException toe){
            throw new AssertionError(toe.getMessage());
        }
        return true;
    }

}
