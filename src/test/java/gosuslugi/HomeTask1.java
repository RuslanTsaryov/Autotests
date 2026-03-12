package gosuslugi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

//min: Выбрать Регион подачи жалобы, прописать локаторы: xpath элементов или css
//max: Написать методы для прокликивания элементов, добавить скроллы и ожидания
public class HomeTask1 {
    WebDriver driver;

    @Test
    public void changeRegion() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "incognito"
        );
        driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://knd.gosuslugi.ru");
        //css селектор
        WebElement regionSelect = driver.findElement(By.cssSelector("div.location-select a[role='button']"));
        //Скролл до кнопки выбора региона. Пробовал через js скрипт, такой вариант требовал дополнительной паузы перед кликом
        //видимо не успевало доскроллить до элемента
        actions.moveToElement(regionSelect)
                .click(regionSelect)
                .perform();

        //Клик по радиобаттону Вручную
        //css селектор
        WebElement manualRegionSelect = driver.findElement(By.cssSelector("#app-radio-1"));
        manualRegionSelect.click();

        //Ввод текста "Абакан" в поле поиска региона
        //css селектор; использование # вместо id в данном случае приводит к ошибке
        WebElement regionInput = driver.findElement(By.cssSelector("[id*='search-input']"));
        regionInput.sendKeys("Абакан");

        //Наведение курсора на первый элемент выпадающего списка
        WebElement firstRegion = driver.findElement(By.xpath("//div[@itemid='95401000000']"));

        actions.moveToElement(firstRegion);
        //Скролл в списке и выбор элемента Вологодская обл/Кадуйский р-н/деревня Абаканово
        WebElement regionToSelect = driver.findElement(By.xpath("//div[@itemid='19226816002']"));
        actions.scrollToElement(regionToSelect)
                .click(regionToSelect)
                .perform();

        //Клик на кнопку Применить
        WebElement submitButton = driver.findElement(By.xpath("//span[contains(text(), 'Применить')]"));
        submitButton.click();
    }
}