package gosuslugi2.data;

public enum TestParameters {

    REGION_1("СОСН Омский садовод", "Биофабрика п");

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