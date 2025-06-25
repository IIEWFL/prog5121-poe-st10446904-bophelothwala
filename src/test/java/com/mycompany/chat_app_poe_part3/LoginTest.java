/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chat_app_poe_part3;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {
    
    public LoginTest() {
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

    /**
     * Test of Register method, of class Login.
     */
    @Test
    public void testRegister() {
        System.out.println("Register");
        User user1 = null;
        Scanner input = null;
        Login instance = new Login();
        instance.Register(user1, input);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String joinUsername = "kyl_1";
        boolean expResult = true;
        boolean result = Login.checkUserName(joinUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String joinPassword = "Ch&&sec@ke99";
        boolean expResult = true;
        boolean result = Login.checkPasswordComplexity(joinPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkCellphoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellphoneNumber() {
        System.out.println("checkCellphoneNumber");
        String cellphoneNumber = "+278389689";
        boolean expResult = true;
        boolean result = Login.checkCellphoneNumber(cellphoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        User user1 = null;
        String joinUsername = "kyl_1";
        String joinPassword = "Ch&&sec@ke99";
        String cellphoneNumber = "+278389689";
        Login.registerUser(user1, joinUsername, joinPassword, cellphoneNumber);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        User user1 = null;
        Scanner input = null;
        Login instance = new Login();
        instance.loginUser(user1, input);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of LoginStatus method, of class Login.
     */
    @Test
    public void testLoginStatus() {
        System.out.println("LoginStatus");
        User user1 = null;
        String inputUsername = "kyl_1";
        String inputPassword = "Ch&&sec@ke99";
        String expResult = "Succcessfully Logged In";
        String result = Login.LoginStatus(user1, inputUsername, inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of AvailableUsers method, of class Login.
     */
    @Test
    public void testAvailableUsers() {
        System.out.println("AvailableUsers");
        User user1 = null;
        Login instance = new Login();
        instance.AvailableUsers(user1);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
