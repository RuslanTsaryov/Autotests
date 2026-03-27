package gosuslugi2.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelp {
    WebDriver driver;

    protected static Actions actions;
    //инициализация actions
    public static void init(WebDriver driver) {
        actions = new Actions(driver);
    }

    public static void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element)
                .click(element)
                .perform();
    }
}