package tests;

import pills.AdultIbuprofen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdultIbuprofenTest {
    //contsants
    //needs a delta to compare margin of error for double getters
    private static final double DELTA = 0.001;
    private static final String DEF_NAME = "Ibuprofen";
    private static final double DEF_STRENGTH = 200.0;
    private static final double DEF_SIZE = 4.4;
    private static final String DEF_COLOR = "white";
    private static final String DEF_OUTERCAP = "Gelatin";
    private static final String DEF_AQUEOUS = "Saline";
    private static final String DEF_ACTIVE = "Ibuprofen";

    private static final String TO_DESCRIPTION_F = "The pill %s is a %s colored %s milimeter pill that comes in a dosage of %s mg. The outer casing is made of a %s and the solution inside is %s with the active ingredient being %s.";
    private static final String TO_STRING_F = "Name: %s Strength (mg): %s Size (mm): %s Color: %s";
     
    class AdultIbuprofenMock extends AdultIbuprofen {
        AdultIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    private AdultIbuprofen bigIbuprofen;

    @BeforeEach
    public void BeforeEach(){
        bigIbuprofen = new AdultIbuprofenMock("Gelatin", "Saline", "Ibuprofen");
    }

    @Test
    public void testName() {
        assertEquals(bigIbuprofen.getName(), DEF_NAME);
    }
    
    @Test
    public void testActiveIngredient(){
        assertEquals(bigIbuprofen.getActiveIngredient(), DEF_ACTIVE);
    }

    @Test 
    public void testStrength() {
        assertEquals(bigIbuprofen.getStrength(), DEF_STRENGTH, DELTA);
    }


    @Test 
    public void testSize(){
        assertEquals(bigIbuprofen.getSize(), DEF_SIZE, DELTA);
    }
    
    @Test
    public void testColor() {
        assertEquals(bigIbuprofen.getColor(), DEF_COLOR);
    }
    
    @Test 
    public void testAqueousSolution()
    {
        assertEquals(bigIbuprofen.getAqueousSolution(), DEF_AQUEOUS);
    }

    @Test
    public void testCasing() {
        assertEquals(bigIbuprofen.getOuterCasing(), DEF_OUTERCAP);
    }

}