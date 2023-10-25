/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johnson
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
    @Before
    public void setUp() {
        System.out.println("Setup before each test");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test //See if account is equal even if switched
    public void AccountEqual(){
        String result = "select * from account where user_name='Hannah' and password='12345'";
        String Hannah = "select * from account where password='12345' and user_name='Hannah'";
        assertEquals(result, Hannah);
        //This was a fail
    }
    
    @Test //Null Check
    public void AccountNullCheck(){
        String result = "select * from accont where user_name='Harry'";
        assertNotNull(result);
    }
    
}
