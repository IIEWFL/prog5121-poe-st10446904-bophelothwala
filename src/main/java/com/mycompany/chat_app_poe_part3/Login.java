/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat_app_poe_part3;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Login {
    public void Register(User user1, Scanner input) {
        input.nextLine(); //ensure the input process of the app works
        
        System.out.println("\nEnter a username (must have less than 5 character and an underscore): ");
            
        String userName = input.nextLine();
            
       char[] usernameCharacters = userName.toCharArray();
            
        String joinUsername = new String(usernameCharacters);
            
        boolean validUserName = checkUserName(joinUsername);
            
        if(!validUserName) {
            System.out.println("\nUsername requirements met: False");
            return;
        } else {
            System.out.println("\nUsername requirements met: True");
        }
            
        System.out.println("\nEnter a password(must have between 8 and 16 characters, must have a capital letter, a number and a special character): ");
            
        String password = input.nextLine();
            
        char[] passwordCharacters = password.toCharArray();
            
        String joinPassword = new String(passwordCharacters);
            
        boolean validPassword = checkPasswordComplexity(joinPassword);
            
        if(!validPassword) {
            System.out.println("\nPassword requirements met: False");
            return;
        } else {
            System.out.println("\nPassword requirements met: True");
        }
            
            
        System.out.println("\nEnter a Cellphone Number (Must not longer than 10 characters and contains a valid country code): ");
            
        String cellphoneNumber = input.nextLine();
            
        boolean validcellphoneNumber = checkCellphoneNumber(cellphoneNumber);
            
        if (!validcellphoneNumber) {
            System.out.println("\nCellphone number requirements met: False");
            return;
        } else {
            System.out.println("\nCellphone number requirements met: True");
        }
            
        registerUser(user1, joinUsername, joinPassword, cellphoneNumber);
           
    }
    
    public static boolean checkUserName(String joinUsername) {
        if (joinUsername.length() > 5) {
            System.out.println("\nUsername should have 5 or less characters.");
            return false;
        } else if (!joinUsername.contains("_")) {
            System.out.println("\nUsername should have a underscore");
            return false;
        } else if (joinUsername == null || joinUsername == "") {
            System.out.println("\nPlease fill in your username");
            return false;
        } else {
            return true;
        }    
    }
    
    public static boolean checkPasswordComplexity(String joinPassword) {
        if (joinPassword.length() < 8 || joinPassword.length() > 16) {
            System.out.println("\nYour password should be 8 to 16 characters long");
            return false;
        } else if (!joinPassword.matches(".*[A-Z].*")) {
            // checks for a capital letter
            System.out.println("\nYour password must have a capital letter");
            return false;
        } else if (!joinPassword.matches(".*\\d.*")) {
            // checks for a number 
            System.out.println("\nYour password must have a number");
            return false;
        } else if (!joinPassword.matches(".*[^a-zA-Z0-9].*")) {
            // checks for a special character
            System.out.println("\nYour must have a special character (!, @, $, etc.)");
            return false;
        } else if (joinPassword == null || joinPassword == "") {
            System.out.println("\nPlease fill in your password");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean checkCellphoneNumber (String cellphoneNumber) {
        if (!cellphoneNumber.startsWith("+")) {
            System.out.println("\nYour country code must have a + sign at the beginning!");
            return false;
        }
        
        if (!cellphoneNumber.contains("+27")) {
            System.out.println("\nYour country code is incorrect!");
            return false;
        }
        
        if (cellphoneNumber.length() > 10) {
            System.out.println("\nCellphone number should have 10 characters or less");
            return false;
        }
        
        if (cellphoneNumber == null || cellphoneNumber == "") {
            System.out.println("\nPlease fill in your username");
            return false;
        }
            
        return true;    
    }
    
    public static void registerUser(User user1, String joinUsername, String joinPassword, String cellphoneNumber) {
        user1.setUserName(joinUsername);
        user1.setPassword(joinPassword);
        user1.setCellPhoneNumber(cellphoneNumber);
        
        System.out.println("\nWelcome, " + user1.getUserName() +
                           "\nPassword: " + user1.getPassword() + 
                           "\nCellphone number: " + user1.getCellPhoneNumber()
        );
        
    }
    
    public void loginUser(User user1, Scanner input) {

        Message message = new Message();
        
        if (user1.getUserName() == null || user1.getPassword() == null || user1.getCellPhoneNumber() == null) {
            System.out.println("\nNo users registered, register first.");
            return;
        }
        
        input.nextLine(); // ensure loggin process works
        
        
        System.out.println("\nPlease enter your registered userName: ");
        
        String inputUsername = input.nextLine();
            
        System.out.println("\nPlease enter your registered password: ");
            
        String inputPassword = input.nextLine();
            
        String logginStatus = LoginStatus(user1, inputUsername, inputPassword);
            
        System.out.println("\nStatus: " + logginStatus);
            
        if (logginStatus.equals("Succcessfully Logged In")) {
            System.out.println("Welcome, " + inputUsername);
            message.start(input, user1);
        }
            
        if (logginStatus.equals("Log In failed, check that your details are correct")) {
            System.out.println("Ensure your details you registered with are correct.");
        }
            
    }
    
    public static String LoginStatus(User user1, String inputUsername, String inputPassword) {
        if (!inputUsername.equals(user1.getUserName()) || user1.getUserName() == null) {
            System.out.println("\nUsername does not exist");
            return "Log In failed, check that your details are correct";
        }
        
        if (!inputPassword.equals(user1.getPassword()) || user1.getPassword() == null) {
             System.out.println("\nIncorrect password!");
            return "Log In failed, check that your details are correct";
        }
        
        return "Succcessfully Logged In";
    }
    
    // chech for users
    public void AvailableUsers (User user1) {
        System.out.println("User saved: " + 
                           "\n" + user1.getUserName()
        );
    }
}
