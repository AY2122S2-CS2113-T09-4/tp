package seedu.simplst;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitGoodTest {

    @Test
    public void convertCapacity_integerInput_CapacityMedium() { //to test if integer inputs are set to MEDIUM by default
           String capacity = "1";
           UnitGood testUnitGood = new UnitGood("WC1", "Wooden chair", "From Germany", capacity);
           assertEquals(Capacity.MEDIUM, testUnitGood.getCapacity());
    }

    @Test
    public void convertCapacity_alphaNumericInput_CapacityDefault() { //to test if integer inputs are set to MEDIUM by default
        String capacity = ">/?l";
        UnitGood testUnitGood = new UnitGood("WC1", "Wooden chair", "From Germany", capacity);
        assertEquals(Capacity.MEDIUM, testUnitGood.getCapacity());
    }

    @Test
    public void convertCapacity_caseSensitivity_CapacitySmall() {
        String smallCaseCapacity = "small";
        String upperCaseCapacity = "SMALL";
        String mixCaseCapacity = "sMaLL";
        UnitGood smallCaseUnitGood = new UnitGood("WC1", "Wooden chair", "From Germany",
                smallCaseCapacity);
        UnitGood upperCaseUnitGood = new UnitGood("WC1", "Wooden chair", "From Germany",
                upperCaseCapacity);
        UnitGood mixCaseUnitGood = new UnitGood("WC1", "Wooden chair", "From Germany",
                mixCaseCapacity);
        assertEquals(Capacity.SMALL, smallCaseUnitGood.getCapacity());
        assertEquals(Capacity.SMALL, upperCaseUnitGood.getCapacity());
        assertEquals(Capacity.SMALL, mixCaseUnitGood.getCapacity());
    }
}