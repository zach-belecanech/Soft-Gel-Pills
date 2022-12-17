package tests;
/* 
 * JUnit5 test class
 */
import pills.GelCap;
import pills.Inspector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public  class GelCapTest {
    GelCap pill;

    //contsants
    //needs a delta to compare margin of error for double getters
    private static final double DELTA = 0.001;
    private static final String DEF_NAME = "Tylenol";
    private static final double DEF_STRENGTH = 300.0;
    private static final double DEF_SIZE = 100.0;
    private static final String DEF_COLOR = "White";
    private static final String DEF_OUTERCAP = "gelatin";
    private static final String DEF_AQUEOUS = "ethanol";
    private static final String DEF_ACTIVE = "Acetaminophen";
    private static final String TO_DESCRIPTION_F = "The pill %s is a %s colored %s milimeter pill that comes in a dosage of %s mg. The outer casing is made of a %s and the solution inside is %s with the active ingredient being %s.";
    private static final String TO_STRING_F = "Name: %s Strength (mg): %s Size (mm): %s Color: %s";
    
    class GelCapMock extends GelCap {
        GelCapMock (String name, double strength, double size, String color, String casing, String solution, String active) {
            super(name, strength, size, color, casing, solution, active);        
        }

        public void accept(Inspector inspector) {}

    } 

     @BeforeEach
    public void BeforeEach() {
	 pill = new GelCapMock(DEF_NAME, DEF_STRENGTH, DEF_SIZE, DEF_COLOR, DEF_OUTERCAP, DEF_AQUEOUS, DEF_ACTIVE);
    }

    @Test
    public void testGetName() {
        String testName = pill.getName();
        assertEquals(DEF_NAME, testName);
    }

    @Test
    public void testGetStrength() {
        double testStrength = pill.getStrength();
        assertEquals(DEF_STRENGTH, testStrength, DELTA);
    }

    @Test
    public void testGetSize() {
        double testSize = pill.getSize();
        assertEquals(DEF_SIZE, testSize, DELTA);
    }

    @Test
    public void testGetColor() {
        String testColor = pill.getColor();
        assertEquals(DEF_COLOR, testColor);
    }

    @Test
    public void testToString() {
        String testString = pill.toString();
        assertEquals(String.format(TO_STRING_F,DEF_NAME,DEF_STRENGTH,DEF_SIZE,DEF_COLOR),testString);
    }

    @Test
    public void testToDescription() {
        String testDescription = pill.description();
        assertEquals(String.format(TO_DESCRIPTION_F,DEF_NAME,DEF_COLOR,DEF_SIZE,DEF_STRENGTH,DEF_OUTERCAP,DEF_AQUEOUS,DEF_ACTIVE),testDescription);
    }

    @Test
    public void testGetOuterCapsule() {
        String testOuterCapsule = pill.getOuterCasing();
        assertEquals(DEF_OUTERCAP, testOuterCapsule);
    }

    @Test
    public void testAqueousSolution() {
        String testAqueousSolution = pill.getAqueousSolution();
        assertEquals(DEF_AQUEOUS, testAqueousSolution);
    }

    @Test
    public void testActiveIngredient() {
        String testActiveIngredient = pill.getActiveIngredient();
        assertEquals(DEF_ACTIVE, testActiveIngredient);
    }
}