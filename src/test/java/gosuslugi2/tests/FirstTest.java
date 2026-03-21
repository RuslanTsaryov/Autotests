package gosuslugi2.tests;

import gosuslugi2.data.TestParameters;
import gosuslugi2.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

public class FirstTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        mainPage = new MainPage(driver);
    }
/*
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

 */

    @Test
    public void changeRegion() {
        String regionToSet = "СОСН Омский садовод";
        String expectedValue = "Биофабрика п";
        mainPage.setRegion(regionToSet);

        //Обратиться к элементу, вытащить текст и сверить с ожидаемым
        mainPage.checkResult(expectedValue);
    }

    //Параметризированный тест
    @ParameterizedTest
    @CsvSource({"СОСН Омский садовод, Биофабрика п"})
    public void changeRegionParam(String regionToSet, String expectedValue) {
        mainPage.setRegion(regionToSet);

        //Обратиться к элементу, вытащить текст и сверить с ожидаемым
        mainPage.checkResult(expectedValue);
    }

    //Если парамтеров много, то лучше делать через enum
    @ParameterizedTest
    @EnumSource(TestParameters.class)
    public void changeRegionParamE(TestParameters testParameters) {
        mainPage.setRegion(testParameters.getRegionToSet());

        //Обратиться к элементу, вытащить текст и сверить с ожидаемым
        mainPage.checkResult(testParameters.getExpectedValue());
    }
}