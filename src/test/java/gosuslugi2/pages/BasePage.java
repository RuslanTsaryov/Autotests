package gosuslugi2.pages;

import gosuslugi2.helpers.ActionHelp;
import gosuslugi2.helpers.WaitHelp;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        ActionHelp.init(driver);
        WaitHelp.init(driver, Duration.ofSeconds(5));
    }
}