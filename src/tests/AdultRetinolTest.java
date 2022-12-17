package tests;


import pills.AdultRetinol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdultRetinolTest{
    private static final double DELTA = 0.001;
    private static final String DEF_NAME = "Retinol";
    private static final double DEF_STRENGTH = 0.6;
    private static final double DEF_SIZE = 2.0;
    private static final String DEF_COLOR = "tan";
    private static final String DEF_OUTERCAP = "Plasticizer";
    private static final String DEF_AQUEOUS = "Saline";
    private static final String DEF_ACTIVE = "Retinol";

    private static final String TO_DESCRIPTION_F = "The pill %s is a %s colored %s milimeter pill that comes in a dosage of %s mg. The outer casing is made of a %s and the solution inside is %s with the active ingredient being %s.";
    private static final String TO_STRING_F = "Name: %s Strength (mg): %s Size (mm): %s Color: %s";
     
    class AdultRetinolMock extends AdultRetinol {
        AdultRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    AdultRetinol bigRetinol;

    @BeforeEach
    public void beforeEach(){
        bigRetinol = new AdultRetinolMock("Plasticizer", "Saline", "Retinol");
    }
    
    @Test
    public void testName() {
        assertEquals(bigRetinol.getName(), DEF_NAME);
    }

    @Test
    public void testActiveIngredient(){
        assertEquals(bigRetinol.getActiveIngredient(), DEF_ACTIVE);
    }

    @Test 
    public void testStrength() {
        assertEquals(bigRetinol.getStrength(), DEF_STRENGTH, DELTA);
    }


    @Test 
    public void testSize(){
        assertEquals(bigRetinol.getSize(), DEF_SIZE, DELTA);
    }
    
    @Test
    public void testColor() {
        assertEquals(bigRetinol.getColor(), DEF_COLOR);
    }
    
    @Test 
    public void testAqueousSolution()
    {
        assertEquals(bigRetinol.getAqueousSolution(), DEF_AQUEOUS);
    }

    @Test
    public void testCasing() {
        assertEquals(bigRetinol.getOuterCasing(), DEF_OUTERCAP);
    }

}