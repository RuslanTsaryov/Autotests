package gosuslugi2.pages;

import gosuslugi2.elements.Button;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static gosuslugi2.helpers.ActionHelp.moveToElementAndClick;

public class MainPage extends BasePage {
    @FindBy(css = "div.location-select a[role='button']")
    private WebElement regionSelectButton;

    @FindBy(css = "#app-radio-1")
    private WebElement manualRegionSelectRadioButton;

    @FindBy(css = "[id*='search-input']")
    private WebElement regionInput;

    @FindBy(xpath = "//span[contains(text(), 'Применить')]")
    private WebElement submitButton;

    @FindBy(css = "div.location-select a[role='button']")
    private Button someButton;

    //Конструктор, с помощью него создается экземпляр класса
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void setRegion(String region) {
        moveToElementAndClick(regionSelectButton);
        //Код дополнненый при выполнении ДЗ #2
        manualRegionSelectRadioButton.click();
        regionInput.sendKeys(region);
        selectRegionXpath(region);
        submitButton.click();
    }

    public void selectRegionXpath(String region) {
        WebElement regionToSelect = driver.findElement(
                By.xpath(String.format("//span[@class='highlighted' and contains(text(), '%s')]", region))
        );
        moveToElementAndClick(regionToSelect);
    }

    public void someMethod() {
        someButton.customClick();
    }

    //ДЗ #3:
    public void checkResult(String expected) {
        //применить ассерты
        String actual = regionSelectButton.getText();
        Assertions.assertEquals(expected, actual);
    }
}