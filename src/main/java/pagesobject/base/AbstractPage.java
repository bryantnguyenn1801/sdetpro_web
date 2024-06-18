package pagesobject.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static utils.WaitUtils.waitForElement;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;
    Actions action;
    WebElement element;

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

    protected void clearTextElementWithKeys(WebElement element) {
        waitForElement(element);
        this.selectAllWithKeys(element);
        this.action = new Actions(this.driver);
        this.action.sendKeys(new CharSequence[]{Keys.DELETE}).build().perform();
    }

    public void selectAllWithKeys(WebElement element) {
        click(element);
        String os = System.getProperty("os.name");
        this.action = new Actions(this.driver);
        if (os.contains("Mac")) {
            this.action.keyDown(Keys.COMMAND).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.COMMAND).build().perform();
        } else {
            this.action.keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL).build().perform();
        }

    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void selectItemInDropdown(WebElement element, String expectedValueInDropdown) {
        waitForElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(expectedValueInDropdown);
    }

    public void clickToElementByJavascript(WebElement ele) {
        this.javascriptExecutor = (JavascriptExecutor) this.driver;
        this.javascriptExecutor.executeScript("arguments[0].click();", new Object[]{ele});
    }

    public void scrollToElement(Object locatorOrElement, String... values) {
        if (locatorOrElement instanceof WebElement) {
            this.element = (WebElement) locatorOrElement;
        } else {
            String locator = String.format((String) locatorOrElement, (Object[]) values);
            this.element = this.driver.findElement(By.xpath(locator));
        }

        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{this.element});
        this.sleepTimeInMilSecond(500);
    }

    public void sleepTimeInMilSecond(int milSecond) {
        try {
            Thread.sleep((long) milSecond);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }
    }

    public void selectItemInCustomDropdown(String parentCss, String allItemCss, String expectedItem) throws Exception {
        this.javascriptExecutor = (JavascriptExecutor) this.driver;
        WebElement parentDropdown = this.driver.findElement(By.cssSelector(parentCss));
        this.javascriptExecutor.executeScript("arguments[0].click();", new Object[]{parentDropdown});
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
        List<WebElement> all_Item = this.driver.findElements(By.cssSelector(allItemCss));
        Iterator var6 = all_Item.iterator();

        while (var6.hasNext()) {
            WebElement childElement = (WebElement) var6.next();
            if (childElement.getText().equals(expectedItem)) {
                this.javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", new Object[]{childElement});
                Thread.sleep(1000L);
                if (childElement.isDisplayed()) {
                    childElement.click();
                } else {
                    this.javascriptExecutor.executeScript("arguments[0].click();", new Object[]{childElement});
                }

                Thread.sleep(1000L);
                break;
            }
        }

    }
}
