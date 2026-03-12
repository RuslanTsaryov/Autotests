package gosuslugi;

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
import java.util.List;

public class FirstTest {
    WebDriver driver;

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
}