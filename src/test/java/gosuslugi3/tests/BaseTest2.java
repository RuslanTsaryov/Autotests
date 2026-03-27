package gosuslugi3.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest2 {

    @BeforeEach
    public void setDriver() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.headless = false;
        Configuration.browser = "chrome";

        open("https://knd.gosuslugi.ru");
    }
}