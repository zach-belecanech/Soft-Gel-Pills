package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pills.AdultIbuprofen;
import pills.AdultRetinol;
import pills.ChildIbuprofen;
import pills.ChildRetinol;
import pills.ConsistencyInspector;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConsistencyInspectorTest {

    private static final int DEF_ADULT_COUNT = 2;
    private static int DEF_TEST_ADULT = 0;
    private static int DEF_TEST_CHILD = 0;
    private static final int DEF_CHILD_COUNT = 2;
    private static final Boolean DEF_CONSISTENT_CHECK = true;
    private static final String DEF_CASING_R = "plasticizer";
    private static final String DEF_SOLUTION_R = "saline";
    private static final String DEF_ACTIVE_R = "Retinol";
    private static final String DEF_OUTPUT_AI = "There are 1 milligrams of adult pills and 0 milligrams of child pills.";
    private static final String DEF_OUTPUT_AR = "There are 1 milligrams of adult pills and 0 milligrams of child pills.";
    private static final String DEF_OUTPUT_CR = "There are 0 milligrams of adult pills and 1 milligrams of child pills.";
    private static final String DEF_OUTPUT_CIB = "There are 0 milligrams of adult pills and 1 milligrams of child pills.";



    class ConsistencyInspectorMockeroni extends ConsistencyInspector{
        ConsistencyInspector conIns;
    }

    class AdultRetinolMock extends AdultRetinol {
        AdultRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class ChildRetinolMock extends ChildRetinol {
        ChildRetinolMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class AdultIbuprofenMock extends AdultIbuprofen {
        AdultIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    class ChildIbuprofenMock extends ChildIbuprofen {
        ChildIbuprofenMock(String casing, String solution, String active){
            super(casing, solution, active);
        }
    }

    AdultIbuprofen ai;
    ConsistencyInspector ci = new ConsistencyInspectorMockeroni();
    ChildIbuprofen cib;
    ChildRetinol cr;
    AdultRetinol ar;

    
    @BeforeEach
    public void BeforeEach(){
        ConsistencyInspector ci = new ConsistencyInspectorMockeroni();
        AdultIbuprofen ai = new AdultIbuprofenMock(DEF_CASING_R, DEF_SOLUTION_R, DEF_ACTIVE_R);
        ChildIbuprofen cib = new ChildIbuprofenMock(DEF_CASING_R, DEF_SOLUTION_R, DEF_ACTIVE_R);
        ChildRetinol cr = new ChildRetinolMock(DEF_CASING_R, DEF_SOLUTION_R, DEF_ACTIVE_R);
        AdultRetinol ar = new AdultRetinolMock(DEF_CASING_R, DEF_SOLUTION_R, DEF_ACTIVE_R);
    }   


    @Test
    public void testAIInspect(){
        ci.inspect(ai);
        assertEquals(DEF_OUTPUT_AI,ci.report());
    }

    @Test
    public void testCIInspect(){
        ci.inspect(cib);
        assertEquals(DEF_OUTPUT_CIB,ci.report());
    }

    @Test
    public void testARInspect(){
        ci.inspect(ar);
        assertEquals(DEF_OUTPUT_AR,ci.report());
    }
    @Test
    public void testCRInspect(){
        ci.inspect(cr);
        assertEquals(DEF_OUTPUT_CR,ci.report());
    }

    @Test
    public void testSoFarSoConsistent() {
        ci.inspect(ai);
        ci.inspect(ar);
        assertEquals(DEF_CONSISTENT_CHECK, ci.soFarSoConsistent());
    }




    
}
