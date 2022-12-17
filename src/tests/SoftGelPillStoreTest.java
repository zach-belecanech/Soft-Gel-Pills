package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pills.ChildPillFactory;
import pills.GelCap;
import pills.AdultPillFactory;
import pills.SoftGelPillStore;

public class SoftGelPillStoreTest{

    private ByteArrayInputStream bais;
    private InputStream oldIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream baos;
    private static final String correctLog = "Log in:\nYour Name: Your Age: \nYou have successfully logged in!\n";
    private GelCap[] test_array;
    SoftGelPillStore leStore;
    

    // class childIbuprofenFactMock extends ChildPillFactory {
        
    //         ChildPillFactory childIbuprofenFactMock = getInstance();
       
    // }
    // class adultIbuprofenFactMock extends AdultPillFactory {
    //    AdultPillFactory childIbuprofenFactMock = getInstance();
    // }

    private String getOutput() {
        System.out.flush();
        String output = baos.toString(); 
        return output.replace("\r", ""); 
    }

    @BeforeEach
    public void beforeEach(){
        oldIn = System.in;
        leStore = new SoftGelPillStore();
    }

    @BeforeEach
    public void beforeEach2(){
        originalOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Test
    public void testLogIn()
    {
        String input = "John Smith\n18";
        bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        leStore.logIn();
        assertEquals(correctLog, getOutput());

    }

    @Test
    public void testLogInNeg()
    {
        String input = "John Smith\n-18\n18";
        bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        leStore.logIn();
        assertEquals("Log in:\nYour Name: Your Age: Please enter a valid age\nYour Age: \nYou have successfully logged in!\n", getOutput());

    }

    
    @Test
    public void testDescription(){
        leStore.printOrderDescription();
        assertEquals("You have ordered 0 pills\n", getOutput());
    }

    @Test
    public void testLogOut() {
        String input1 = "John Smith\n18\n1\n";
        bais = new ByteArrayInputStream(input1.getBytes());
        System.setIn(bais);
        leStore.logIn();
        leStore.order();
        int constant = 1;
        int lengthArr = 0;
        if (leStore.logOut() != null) {
            lengthArr = leStore.logOut().length;
        }
        assertEquals(constant, lengthArr);

    }

    @Test
    public void testCalcStrengths() {
        String input1 = "John Smith\n18\n1";
        bais = new ByteArrayInputStream(input1.getBytes());
        System.setIn(bais);
        leStore.logIn();
        leStore.order();
        
        leStore.calcStrengths();
        assertEquals(getOutput().contains("There are 200.0 milligrams of ibuprofen pills and 0.0 milligrams of retinol pills."), true);
    }


    @AfterEach
    public void afterEach(){
        System.setIn(oldIn);
        System.setOut(originalOut);
    }

}
