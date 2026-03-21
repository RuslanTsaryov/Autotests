package gosuslugi2.elements;

import gosuslugi2.helpers.WaitHelp;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void customClick() {
        WaitHelp.checkClickability(webElement);
        webElement.click();
    }
}
