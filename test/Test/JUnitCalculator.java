/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import calculator.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Martins
 */
public class JUnitCalculator {
    private Calculator toTest;
    public JUnitCalculator() {
        toTest = new Calculator();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
     @Test
     public void testEmptyString() throws Exception {
         assertEquals(toTest.add(""), 0);
     }
     
      @Test
     public void testAddOneNumber() throws Exception {
         assertEquals(toTest.add("5"), 5);
     }
     
      @Test
     public void testAddTwoNumbers() throws Exception {
         assertEquals(toTest.add("1,2"), 3);
     }
     
     @Test
     public void testAddMany() throws Exception {
         assertEquals(toTest.add("1,2,3,4"), 10);
     }
     
     @Test
     public void testAddManyUseNewline() throws Exception {
         assertEquals(toTest.add("1\n2,3"), 6);
     }
    
     @Test
     public void testAddManyChangeDelimeter() throws Exception {
         assertEquals(toTest.add("//;\n1;2"), 3);
     }
     
     @Test(expected=NumberFormatException.class)
     public void testAddNegative() throws Exception{
         toTest.add("//;\n-1;2");
     }

     
}