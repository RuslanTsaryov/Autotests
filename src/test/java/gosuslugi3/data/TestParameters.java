package gosuslugi3.data;

public enum TestParameters {

    REGION_1("СОСН Омский садовод", "Биофабрика п"),
    REGION_2("Астрахань/тер. СНТ Виктория", "Астрахань г");

    private String regionToSet;
    private String expectedValue;

    TestParameters(String regionToSet, String expectedValue) {
        this.regionToSet = regionToSet;
        this.expectedValue = expectedValue;
    }

    public String getRegionToSet() {
        return regionToSet;
    }

    public String getExpectedValue() {
        return expectedValue;
    }
}