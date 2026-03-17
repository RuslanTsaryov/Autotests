package gosuslugi2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static gosuslugi2.helpers.ActionHelp.moveToElementAndClick;

public class MainPage extends BasePage {
    @FindBy(css = "div.location-select a[role='button']")
    public WebElement regionSelectButton;

    @FindBy(css = "#app-radio-1")
    public WebElement manualRegionSelectRadioButton;

    @FindBy(css = "[id*='search-input']")
    WebElement regionInput;

    @FindBy(xpath = "//span[contains(text(), 'Применить')]")
    WebElement submitButton;

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

        //Не вынес локатор под аннотацией FindBy, т.к. нужно в него передавать переменную region, чтобы метод setRegion был универсальным
        WebElement regionToClick = driver.findElement(
                By.xpath(String.format("//span[@class='highlighted' and contains(text(), '%s')]", region))
        );
        moveToElementAndClick(regionToClick);
        submitButton.click();
    }
}