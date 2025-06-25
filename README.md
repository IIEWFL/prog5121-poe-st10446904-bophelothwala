[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/FFUFqZ5X)

Name: Bophelo Thwala 

 

Student No.: ST10446904 

 

Module Code: PROG5111 

 

Lecturer: Mr. Steven Ndaye 

 

PROGRAMMING 1A – POE part 1 - 3 

 

 

 

 

 

 

 

 

 

Chat App  

 

Part 1: User Authentication 

 

A list of options will display, you can enter a number, you can enter a number based on the options given e.g. user press 1 => 1. Register 

           Options: 

          1. Register 

          2. Login 

         3. Check Users 

        0. Exit App 

 

 

 

The user has the option to exit the app by pressing 0 

 

The user has the option to press 3 to verify if any usernames were stored 

 

 

2. Registration 

 

 

 

 

The user will be prompted to enter user details such as (username, password and cellphone number) 

 

Measures have been placed to ensure the user cannot skip any registration steps such as 

              - Making sure the user has entered something 

                   If username == null or password == null or cellphoneNumber == null 

                        Output “Make sure you have entered all the details” 

             - Followed the username conditions (less than 5 characters and has an underscore) 

 

       - Followed the password conditions (have 8 to 16 characters, a capital letter, a number and a special character). 

      - Followed the cellphone number conditions (has an international code, no more than 10 characters). 

    

 

3. Login 

 

 

The user will be prompted to enter user details used in the registration process. 

 

Measures have been placed to ensure the user cannot skip any login steps such as 

              - Making sure the user has entered something 

                    If inputUsername == null or inputPassword == null or inputCellphoneNumber == null 

                       Output “You did not enter anything” 

             - The entered username matches the registered username 

                   If inputUsername != user1.getUsername() 

                       Output “Username does not exist” 

       

             - The entered password matches the registered password. 

                   If inputUsername != user1.getPassword() 

                       Output “Incorrect password” 

 

           - The cellphone number entered matches the registered cellphone number. 

 

              If inputUsername != user1.getCellPhoneNumber() 

                       Output “Incorrect phone number” 

 

 

3. Check Users 

 

Has been added to ensure the user’s information you have registered is stored. 

 

 

Codes of the chat app poe part 1 in java is available at: 

https://github.com/IIEWFL/prog5121-part-1-st10446904-bophelothwala.git 

 

 

 

Part 2: Sending Messages 

 

After the user has logged in, you will be given three options: 

Send Messages  

Recently Sent Messages (WIP) 

Quit 

 

 

 

Type on the console option 1 to send messages, type on the console option 2 to see recently sent messages, you will get the text (Coming soon...), type on the console option 3 to return to the main menu. 

 

 

 

The user can send messages by entering the phone number (It will be checked, it must be less than 12 characters, start with +27), and the message texting not exceeding 250 characters. 

 

Then, a message hash will be created to be stored, a random message ID will be generated for tracking, and both message ID and text message will be stored in an Array List. 

 

Afterwards, the user can decide to: 

Send Message – The message will be sent. 

 

Store Message – The message will be stored in an array and json file. 

 

Discard Message – The message will not be sent or stored. 

 

Continue – Continue to the sending text menu. 

 

 

 

 

Codes of the chat app poe part 2 in java is available at: 

https://github.com/IIEWFL/prog5121-part-2-st10446904-bophelothwala.git 

 

Part 3: Store data and display report 

 

Changes made from POE part 2: 

Welcome message and app options are displayed on JOptionPane and the app options are displayed on the console as well. 

 

A for loop is used to send as many messages as possible if it is a message or more than one message and it should be working 

 

Random numbers for the message ID are made and converted into a string. 

 

Random numbers for the message Hash are made and converted into a string. 

 

Message details should be anble to display correctly and be stored in the JSON file and their designated Array Lists. 

 

 

All the arrays in the message.java file, can accommodate the following Message IDs, Message Texts, Recipient’s Cellphone Numbers, Discarded Messages and Message Hashes for each message sent. Code example: 

 ArrayList<String> messageIDs =  new ArrayList<>(); 

-        ArrayList<String> messageTexts = new ArrayList<>(); 

-        ArrayList<String> recipientCellNumbers = new ArrayList<>(); 

-        ArrayList<String> discardedMessages = new ArrayList<>(); 

-       ArrayList<String> messageHashes = new ArrayList<>(); 

 

 

Referring to this menu: 

 After the user has logged in, you will be given three options: 

Send Messages  

Recently Sent Messages  

Quit 

 

Press 2 to be able to: “1. Display the sender and recipient of all sent messages”, “2. Display the longest message”, “3.  Search for message ID or recipient cell number and displays the corresponding recipient and message”, “4. Delete a message using a message hash” and “5. Display a full report of all messages sent.” 

 

Display the sender and recipient of all sent messages: This will display the sender’s details and recipient details 

 

 

Display the longest message: Using a binary search algorithm and checking the length of each text will display the full details of the longest message. 

 

Search using Message ID or Recipient cell number: You can search using either an existing message ID or a recipient cell number. 

 

Delete a message using the message hash: You can delete a message and its details by entering an existing message Hash (N.B. Check all messages before deleting). 

 

Display a full report of all messages sent: Displays all details for every message that was sent. 

 

 

 

Project Summary and Overview 

 

The User will be required to register and login into the chat app and you can check if your account is registered by pressing 3. for available users 

 

Register and login with your username must have an underscore and must be less than 5 characters, password must be between 8 and 16 characters long and must contain a capital letter, special character s(! , @, #), and numbers, cellphone number containing the country code (+27) and must be 10 characters long. 

 

After logging in, you can send messages to someone using the the recipient’s cellphone number, enter the text you want to send, and the message ID, message Hash will be generated and you can decide to send, store, discard the message and if you continue without sending the message will also be discarded. 

 

You can check recently sent messages by displaying the sender and recipient of all sent messages, displaying the longest message, searching for a message using a message ID or recipient cell number, deleting a message using a message hash, and displaying a full report of all messages sent.  

 

The programming language used for the project was Java in the Apache NetBeans IDE. 

 

 

 

Functionality and Features 

 

User Authentication: The user can register an account and login to access the application. The program checks if each user has the expected requirements of the registration process and ensures that the username and password entered is the username and password that the user registered with. 

 

Sending Messages: The user can send messages by entering the recipient's cell number and the message text and the message ID and message Hash is auto generated. The user can decide to send, store, and discard the message. 

 

Viewing sent and stored Messages: The user can view the messages that were sent by displaying the sender and recipient of all sent messages, displaying the longest message, searching for a message using a message ID or recipient cell number, deleting a message using a message hash, and displaying a full report of all messages sent. 

 

 

Step-by-Step Guide 

 

Open the app 

 

 Register your account and Login with your username and password (check available users if your username is there.) 

 

After logging in, you can send messages by pressing 1, you can choose how many messages to send. 

 

Enter the recipient’s cell number and the text you want to send then you will decide to send, store or discard the message if neither, press 4 to proceed to write another message. 

 

You can view the messages sent by pressing 2 in the menu after logging in; you can choose to display the sender and recipient of all sent messages (displays all messages), display the longest message, searching for a message by entering a  message ID or recipient cell number (the option will be given to you to search for a message using a message ID or cell number), deleting a message using a message hash (enter a message hash to delete the message), and displaying a full report of all messages sent. 

 

 
Codes of the chat app poe part 3 in java is available at:
https://github.com/IIEWFL/prog5121-poe-st10446904-bophelothwala.git

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

Reference list 

 

Part 1: 

 

AI used: Claude 

 

My prompt: Can you show me an example how to check if a user has correctly followed these conditions when registering or loggin in with these conditions: Password - Must contain a capital letter, a number, a special character, cellphone number - it must start with country code in java 

 

 

Anthropic. (2025). Claude 3.7 Sonett (Feb 19 version) [Large language model]. 

https://claude.ai/new 

 

 

 

 

Part 2 

 

AI used: Claude 

 

My prompt: how can i store messages in a json file and what should the json file look like based on this (do not change anything in the code, just show how to store messages) 

 

Anthropic. (2025). Claude 3.7 Sonett (Feb 19 version) [Large language model]. 

 

https://claude.ai/new 

 

