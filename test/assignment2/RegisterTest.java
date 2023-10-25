/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johnson
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    
    @Test //this will be a fail cause User_Names aren't equal
    public void testPast(){
        String Peter = "select * from account where user_name='Peter'";
        String result = "slect * from account where user_name='Steve'";
        assertEquals(Peter, result);
    }
    
    @Test //this will be an error cause User_Names are the same
    public void testException(){
        String result = "select * from account where user_name='Peter'";
        String Peter = "select * from account where user_name='Peter'";
        assertNotEquals(result, Peter);
    }
    
    @Test //null check
    public void testAssertNull(){
        String result = "select * from account where user_name='Ralph'";
        assertNotNull(result);
        assertNull(result);
    }
    
}
