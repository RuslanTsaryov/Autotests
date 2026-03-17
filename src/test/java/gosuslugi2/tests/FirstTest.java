package gosuslugi2.tests;

import gosuslugi2.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void check() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //Неявные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://knd.gosuslugi.ru");
        WebElement element = driver.findElement(By.xpath("//a[@class='button-in-out']"));
        element.click();
        WebElement elementUserName = driver.findElement(By.cssSelector("#login"));
        elementUserName.sendKeys("TestLogin");
        WebElement elementPassword = driver.findElement(By.cssSelector("#password"));
        elementPassword.sendKeys("TestPsw");
//        List<WebElement> elements = driver.findElements(By.cssSelector(""));
        //сложные действия (дабл клик и тд)
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
        //scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");
        //Явные ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Test
    public void changeRegion() {
        mainPage.setRegion("СОСН Омский садовод");

        /*
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
         */
    }
}