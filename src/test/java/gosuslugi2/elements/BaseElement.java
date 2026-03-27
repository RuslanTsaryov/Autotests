package gosuslugi2.elements;

import org.openqa.selenium.WebElement;

public class BaseElement {
    protected WebElement webElement;

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }
}