package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryManager {
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        return PageFactory.initElements(driver, pageClassToProxy);
    }
}
