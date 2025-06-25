/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chat_app_poe_part3;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Chat_App_POE_part3 {

    /* AI used: Claude
    My prompt: Can you show me an example how to check if a user has correctly followed these conditions when registering or loggin in with these conditions: 
        Password - Must contain a capital letter, a number, a special character, 
        cellphone number - it must start with country code in java 
    Anthropic. (2025). Claude 3.7 Sonett (Feb 19 version) [Large language model]. 

    https://claude.ai/new 

  */

  public static void Menu(Scanner input, User user1, Login login) {

    /* 
      Good sir, if you testing for if user has not entered anything,

      when you press the spacebar nothing displays,

      if this happens please restart the app otherwise, everything else works

      this commented message only applies to this menu menu part of the app

    */
    System.out.println("\nSelect: " + 
                        "\n1. Register" + 
                        "\n2. Login" + 
                        "\n3. Check Users" +
                        "\n0. Exit App"
    );

    int appOption = input.nextInt();

    switch(appOption) {
        case 1:
            login.Register(user1, input);
            Menu(input, user1, login);
            break;

        case 2:
            login.loginUser(user1, input);
            Menu(input, user1, login);
            break;

        case 3:
            // verify if object data was captured
            if(user1.getUserName() == null) {
                System.out.println("\nNo User/s Saved");
                Menu(input, user1, login);
                break;
            } else {
                login.AvailableUsers(user1);
                Menu(input, user1, login);
                break;
            }

        case 0:
            System.out.println("\nExiting App...\n");
            System.exit(0);
            break;

        default:
            System.out.println("\nInvalid Option! TRY AGAIN!");
            Menu(input, user1, login);
        }
    }
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        User user1 = new User();
        Login login = new Login();

        Menu(input, user1, login); 
    }
}
