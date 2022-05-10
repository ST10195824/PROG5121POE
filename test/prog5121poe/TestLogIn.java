/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121poe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class TestLogIn
{
    
    public TestLogIn()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {  
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    
    @Test
    public void testCorrectCheckUsername()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
       
        assertTrue(instance.checkUsername());
        
    }
    
    @Test
     public void testIncorrectCheckUsername()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyle!!!!!!!");
       
        assertFalse(instance.checkUsername());
        
    }
    
    @Test
     public void testCorrectLogUserIn()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        assertTrue(instance.logUserIn("kyl_1", "Ch&&sec@ke99!"));
        
    }
    
     
     @Test
     public void testIncorrectLogUserIn()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        assertFalse(instance.logUserIn("kyle!!!!!!!", "password"));
        
    }
     
     
     
     @Test
     public void testCorrectCheckPasswordComplexity()
    {
        LogIn instance = new LogIn();
        instance.setPassword("Ch&&sec@ke99!");
        assertTrue(instance.checkPasswordComplexity());
        
    }
    
     
     @Test
     public void testIncorrectCheckPasswordComplexity()
    {
        LogIn instance = new LogIn();
        instance.setPassword("password");
        assertFalse(instance.checkPasswordComplexity());
        
    }
     
    @Test
     public void testCorrectRegisterUser()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        String expectedResult = "Username and Password successfully captured";
        String Result =  instance.registerUser();
        assertEquals(expectedResult, Result);
        
    }
    
     
     @Test
     public void testIncorrectUsernameRegisterUser()
    {
        LogIn instance = new LogIn();
       instance.setUserName("kyle!!!!!!!");
        instance.setPassword("Ch&&sec@ke99!");
        String expectedResult = "Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 Characters in length";
        String Result =  instance.registerUser();
        assertEquals(expectedResult, Result);
        
    } 
     
     @Test
     public void testIncorrectPasswordRegisterUser()
     {
       LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("password");
        String expectedResult = "Password must be at least 8 characters and contain at least 1: digit, special character, capital letter, please try again";
        String Result =  instance.registerUser();
        assertEquals(expectedResult, Result);  
     }
     
     
     @Test
     public void testIncorrectBothRegisterUser()
     {
       LogIn instance = new LogIn();
        instance.setUserName("kyle!!!!!!!");
        instance.setPassword("password");
        String expectedResult = "Password must be at least 8 characters and contain at least 1: digit, special character, capital letter and username must contain an underscore and be no more than 5 Characters in length, please try again";
        String Result =  instance.registerUser();
        assertEquals(expectedResult, Result);  
     }
     
     @Test
     public void testIncorrectreturnLoginStatus()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        instance.setFirstName("Geordi");
        instance.setLastName("La Forge");
        String expectedResult = "Username or password incorrect, please try again";
        String Result = instance.returnLoginStatus("bob_1","Password!@#123");
        assertEquals(expectedResult, Result);  
        
    }
     
      @Test
     public void testCorrectreturnLoginStatus()
    {
        LogIn instance = new LogIn();
        instance.setUserName("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        instance.setFirstName("Geordi");
        instance.setLastName("La Forge");
        String expectedResult = "Welcome Geordi La Forge it is great to see you again.";
        String Result = instance.returnLoginStatus("kyl_1","Ch&&sec@ke99!");
        assertEquals(expectedResult, Result);  
        
    }
}
