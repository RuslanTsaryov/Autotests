package gosuslugi3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    //css
    SelenideElement someButtonCss = $("div.location-select a[role='button']");

    //xpath
    SelenideElement someButtonXpath = $x("div.location-select a[role='button']");

    //Коллекция элементов
    //css
    ElementsCollection someList = $$("");
    //xpath
    ElementsCollection someListXpath = $$x("");

    SelenideElement regionSelectButton = $("div.location-select a[role='button']");
    SelenideElement manualRegionSelectRadioButton = $("#app-radio-1");
    SelenideElement regionInput = $("[id*='search-input']");
    SelenideElement submitButton = $x("//span[contains(text(), 'Применить')]");


    public void setRegion(String region) {
        regionSelectButton.click();
        manualRegionSelectRadioButton.click();
        regionInput.sendKeys(region);
        selectRegionXpath(region);
        submitButton.click();
    }

    public void selectRegionXpath(String region) {
        SelenideElement regionToSelect = $x(String.format("//span[@class='highlighted' and contains(text(), '%s')]", region));
        regionToSelect.click();
    }

    public void checkResult(String expected) {
        regionSelectButton.shouldHave(text(expected));
    }

    public void clickSomeButton() {
        someButtonCss.shouldHave(text("Принять"));
        //если нужно изменить длительность ожидания, прописываем через запятую длительность
        someButtonCss.shouldHave(visible, Duration.ofSeconds(5));

        someList.forEach(element -> element.should(text("Test")));
        someList.findBy(attribute("Test"));
        //someList.filterBy();
    }
}