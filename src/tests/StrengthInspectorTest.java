package tests;

import pills.StrengthInspector;
import pills.AdultRetinol;
import pills.AdultIbuprofen;
import pills.ChildIbuprofen;
import pills.ChildRetinol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StrengthInspectorTest {

    private static final String DEF_OUTPUT_AI = "There are 200.0 milligrams of ibuprofen pills and 0.0 milligrams of retinol pills.";
    private static final String DEF_OUTPUT_AR = "There are 0.0 milligrams of ibuprofen pills and 0.6 milligrams of retinol pills.";
    private static final String DEF_OUTPUT_CR = "There are 0.0 milligrams of ibuprofen pills and 0.2 milligrams of retinol pills.";
    private static final String DEF_OUTPUT_CIB = "There are 50.0 milligrams of ibuprofen pills and 0.0 milligrams of retinol pills.";

    class StrengthInspectorMockeroni extends StrengthInspector{
        StrengthInspector StrengthMock;
    }


    class ChildRetinolMock extends ChildRetinol {
        ChildRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class ChildIbuprofenMock extends ChildIbuprofen {
        ChildIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class AdultRetinolMock extends AdultRetinol {
        AdultRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class AdultIbuprofenMock extends AdultIbuprofen {
        AdultIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    StrengthInspector sim = new StrengthInspectorMockeroni();
    AdultIbuprofen bigIbuprofen;
    AdultRetinol bigRetinol;
    ChildIbuprofen lilIbuprofen;
    ChildRetinol lilRetinol;

    @BeforeEach
    public void beforeEach(){
        StrengthInspector sim = new StrengthInspectorMockeroni();
        bigIbuprofen = new AdultIbuprofenMock("Gelatin", "Saline", "Ibuprofen");
        bigRetinol = new AdultRetinolMock("Plasticizer", "Saline", "Retinol");
        lilIbuprofen = new ChildIbuprofenMock("Gelatin", "saline", "Ibuprofen");
        lilRetinol = new ChildRetinolMock("plasticizer", "saline", "Retinol");
    }

    @Test
    public void testInspectAdultIbu(){
        sim.inspect(bigIbuprofen);
        assertEquals(DEF_OUTPUT_AI, sim.report());
    }

    @Test
    public void testInspectChildIbu(){
        sim.inspect(lilIbuprofen);
        assertEquals(DEF_OUTPUT_CIB, sim.report());
    }
    @Test
    public void testInspectAdultRet(){
        sim.inspect(bigRetinol);
        assertEquals(DEF_OUTPUT_AR, sim.report());
    }
    
    @Test
    public void testInspectChildRet(){
        sim.inspect(lilRetinol);
        assertEquals(DEF_OUTPUT_CR, sim.report());
    }

}
