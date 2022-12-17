package tests;

import pills.ChildRetinol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class ChildRetinolTest{

    private static final double DELTA = 0.001;
    private static final String DEF_NAME = "Retinol";
    private static final double DEF_STRENGTH = 0.2;
    private static final double DEF_SIZE = 0.8;
    private static final String DEF_COLOR = "cyan";
    private static final String DEF_CASING = "plasticizer";
    private static final String DEF_SOLUTION = "saline";
    private static final String DEF_ACTIVE = "Retinol";

    class ChildRetinolMock extends ChildRetinol {
        ChildRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    ChildRetinol lilRetinol;

    @BeforeEach
    public void beforeEach(){
        lilRetinol = new ChildRetinolMock("plasticizer", "saline", "Retinol");
    }

    @Test
    public void testName() {
        assertEquals(lilRetinol.getName(), DEF_NAME);
    }
    
    @Test
    public void testActiveIngredient(){
        assertEquals(lilRetinol.getActiveIngredient(), DEF_ACTIVE);
    }

    @Test 
    public void testStrength() {
        assertEquals(lilRetinol.getStrength(), DEF_STRENGTH, DELTA);
    }

    @Test 
    public void testSize(){
        assertEquals(lilRetinol.getSize(), DEF_SIZE, DELTA);
    }
    
    @Test
    public void testColor() {
        assertEquals(lilRetinol.getColor(), DEF_COLOR);
    }
    
    @Test 
    public void testAqueousSolution()
    {
        assertEquals(lilRetinol.getAqueousSolution(), DEF_SOLUTION);
    }

    @Test
    public void testCasing() {
        assertEquals(lilRetinol.getOuterCasing(), DEF_CASING);
    }

}