package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pills.ChildIbuprofen;

public class ChildIbuprofenTest{
    private static final double DELTA = 0.001;
    private static final String DEF_NAME = "Ibuprofen";
    private static final double DEF_STRENGTH = 50;
    private static final double DEF_SIZE = 1.2;
    private static final String DEF_COLOR = "pink";
    private static final String DEF_OUTERCAP = "Gelatin";
    private static final String DEF_AQUEOUS = "saline";
    private static final String DEF_ACTIVE = "Ibuprofen";

    private static final String TO_DESCRIPTION_F = "The pill %s is a %s colored %s milimeter pill that comes in a dosage of %s mg. The outer casing is made of a %s and the solution inside is %s with the active ingredient being %s.";
    private static final String TO_STRING_F = "Name: %s Strength (mg): %s Size (mm): %s Color: %s";

    class ChildIbuprofenMock extends ChildIbuprofen {
        ChildIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    ChildIbuprofen lilIbuprofen;

    @BeforeEach
    public void beforeEach(){
        lilIbuprofen = new ChildIbuprofenMock("Gelatin", "saline", "Ibuprofen");
    }

    @Test
    public void testName() {
        assertEquals(lilIbuprofen.getName(), DEF_NAME);
    }
    
    @Test
    public void testActiveIngredient(){
        assertEquals(lilIbuprofen.getActiveIngredient(), DEF_ACTIVE);
    }

    @Test 
    public void testStrength() {
        assertEquals(lilIbuprofen.getStrength(), DEF_STRENGTH, DELTA);
    }


    @Test 
    public void testSize(){
        assertEquals(lilIbuprofen.getSize(), DEF_SIZE, DELTA);
    }
    
    @Test
    public void testColor() {
        assertEquals(lilIbuprofen.getColor(), DEF_COLOR);
    }
    
    @Test 
    public void testAqueousSolution()
    {
        assertEquals(lilIbuprofen.getAqueousSolution(), DEF_AQUEOUS);
    }

    @Test
    public void testCasing() {
        assertEquals(lilIbuprofen.getOuterCasing(), DEF_OUTERCAP);
    }

}