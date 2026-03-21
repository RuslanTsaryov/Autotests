package gosuslugi2.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelp {
    protected static WebDriverWait wait;

    //инициализация wait
    public static void init(WebDriver driver, Duration timeout) {
        wait = new WebDriverWait(driver, timeout);
    }

    public static void checkClickability(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}