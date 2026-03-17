package gosuslugi2.pages;

import gosuslugi2.helpers.ActionHelp;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        ActionHelp.init(driver);
    }
}