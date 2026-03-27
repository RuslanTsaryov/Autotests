package gosuslugi3.tests;

import gosuslugi3.data.TestParameters;
import gosuslugi3.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

public class FirstTest2 extends BaseTest2 {
    MainPage mainPage = new MainPage();

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
    @CsvSource({"СОСН Омский садовод, Биофабрика п",
            "Астрахань/тер. СНТ Виктория, Астрахань г"})
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