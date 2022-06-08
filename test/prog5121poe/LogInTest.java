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
 * @author mfren
 */
public class LogInTest
{
    
    public LogInTest()
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
    public void testGetUserName()
    {
        System.out.println("getUserName");
        LogIn instance = new LogIn();
        String expResult = "bob_1";
        instance.setUserName(expResult);
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    @Test
    public void testSetUserName()
    {
        System.out.println("setUserName");
        String UserName = "";
        LogIn instance = new LogIn();
        instance.setUserName(UserName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFirstName()
    {
        System.out.println("getFirstName");
        LogIn instance = new LogIn();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFirstName()
    {
        System.out.println("setFirstName");
        String FirstName = "";
        LogIn instance = new LogIn();
        instance.setFirstName(FirstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLastName()
    {
        System.out.println("getLastName");
        LogIn instance = new LogIn();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLastName()
    {
        System.out.println("setLastName");
        String LastName = "";
        LogIn instance = new LogIn();
        instance.setLastName(LastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword()
    {
        System.out.println("getPassword");
        LogIn instance = new LogIn();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword()
    {
        System.out.println("setPassword");
        String Password = "";
        LogIn instance = new LogIn();
        instance.setPassword(Password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *
     */
    @Test
    public void testCheckUsername()
    {
        System.out.println("checkUsername");
        LogIn instance = new LogIn();
        instance.setUserName("bobbbbbb");
        boolean result = instance.checkUsername();
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testLogUserIn()
    {
        System.out.println("logUserIn");
        String userNameArg = "";
        String userPassArg = "";
        LogIn instance = new LogIn();
        boolean expResult = false;
        boolean result = instance.logUserIn(userNameArg, userPassArg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPasswordComplexity()
    {
        System.out.println("checkPasswordComplexity");
        LogIn instance = new LogIn();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterUser()
    {
        System.out.println("registerUser");
        LogIn instance = new LogIn();
        String expResult = "";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
