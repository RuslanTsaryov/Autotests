package gosuslugi2.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = getDriver();
        //Неявные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://knd.gosuslugi.ru");
    }

    @AfterEach
    public void setDown() {
//        if(driver != null) {
//            driver.quit();
//        }
    }

    public WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--incognito"
        );
        return new ChromeDriver(options);
    }
}