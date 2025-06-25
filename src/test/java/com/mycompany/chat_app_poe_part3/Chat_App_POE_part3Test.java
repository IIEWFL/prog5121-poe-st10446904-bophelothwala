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
 * @author Bophelo
 */
public class Chat_App_POE_part3Test {
    
    public Chat_App_POE_part3Test() {
    }
    
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    
    /**
     * Test of main method, of class Chat_App_POE_part3.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Chat_App_POE_part3.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Menu method, of class Chat_App_POE_part3.
     */
    @Test
    public void testMenu() {
        System.out.println("Menu");
        Scanner input = null;
        User user1 = null;
        Login login = null;
        Chat_App_POE_part3.Menu(input, user1, login);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
}
