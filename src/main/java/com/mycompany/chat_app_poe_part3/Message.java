/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chat_app_poe_part3;

/**
 *
 * @author lab_services_student
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Message {
    public void start(Scanner input, User user1) {
        boolean appRunning = true;
        ArrayList<String> messageIDs =  new ArrayList<>();
        ArrayList<String> messageTexts = new ArrayList<>();
        ArrayList<String> recipientCellNumbers = new ArrayList<>();
        ArrayList<String> discardedMessages = new ArrayList<>();
        ArrayList<String> messageHashes = new ArrayList<>();

        while (appRunning) {
            JOptionPane.showMessageDialog(null, "\nSelect: " +
                    "\n1. Send Messages" +
                    "\n2. Recently sent messages" +
                    "\n3. Quit"
            );
            
            System.out.println("\n1. Send Messages" +
                    "\n2. Recently sent messages" +
                    "\n3. Quit"
            );

            int appOption = input.nextInt();

            switch (appOption) {
                case 1:
                    message(input, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
                    break;

                case 2:
                    recentlySentMessages(input, user1, messageIDs, messageTexts, recipientCellNumbers, 
                    discardedMessages, messageHashes);
                    break;

                case 3:
                    appRunning = false;
                    break;
            }

        }
    }

    public static void message(Scanner input, ArrayList<String> messageIDs , ArrayList<String> messageTexts, 
    ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages,
    ArrayList<String> messageHashes) {
        

        System.out.println("\nDo you want send a message (Y/N):");

        char messageOption = input.next().charAt(0);
        input.nextLine(); // Consume newline

        if (messageOption == 'Y' || messageOption == 'y') {
            System.out.println("\nHow many messages do you want to send?: ");

            int amountOfMessages = input.nextInt();
            input.nextLine(); // Consume newline

            if (amountOfMessages > 0) {
                for (int i = 0; i < amountOfMessages; i++) {
                    System.out.println("\nEnter the receipient's cell number: ");
                    String recipientCellNumber = input.nextLine().trim();

                    boolean validReceipientNumber = checkRecipientNumber(recipientCellNumber);

                    if (validReceipientNumber == true) {
                        System.out.println("\nCellphone is valid!");
                    } else {
                        System.out.println("\nInvalid cellphone number!");
                        continue; // Continue to next iteration instead of returning
                    }

                    System.out.println("\nEnter the message: ");
                    String messageText = input.nextLine();

                    if (messageText.length() > 250) {
                        System.out.println("\nMessage is invalid. It is either too long or too short");
                        continue; // Continue to next iteration instead of returning
                    } else {
                        System.out.println("\nMessage is valid!");
                    }

                    String messageID = Integer.toString((int) (Math.random() * 1000000));
                    boolean validMessageID = checkMessageID(messageID, messageIDs);

                    if (validMessageID == true) {
                        String messageHash = createMessageHash();
                        sendMessage(input, messageIDs, messageTexts, recipientCellNumbers,
                                discardedMessages, messageHashes, messageID, messageText,
                                recipientCellNumber, messageHash);
                    } else {
                        System.out.println("\nInvalid message ID, trying again...");
                        i--; // Retry this iteration
                    }
                }
                System.out.println("\nTotal Messages sent: " + messageIDs.size());
            } else {
                System.out.println("\nInvalid number of messages!");
            }


        } else if (messageOption == 'N' || messageOption == 'n') {
            System.out.println("\nBack to menu...");
        } else {
            System.out.println("\nInvalid option!");
        }
    }

    public static void recentlySentMessages(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {
        boolean continueMenu = true;
        
        while (continueMenu) {
            System.out.println("\n1.View sent messages of sender and receipient" +
                                "\n2.Display longest sent message" +
                                 "\n3.Search" +
                                 "\n4.Delete" +
                                 "\n5.Display all messages" +
                                 "\n6.Display discarded messages" +
                                 "\n7.Exit"
            );

            int checkOption = input.nextInt();
            input.nextLine(); // Consume newline

            switch (checkOption) {
                case 1:
                    viewSentMessagesOfSenderAndReceipient(input, user1, messageIDs, messageTexts, recipientCellNumbers, 
                    discardedMessages, messageHashes);
                    break;

                case 2:
                    displayLongestSentMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, 
                    discardedMessages, messageHashes);
                    break;

                case 3:
                    searchMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, 
                    discardedMessages, messageHashes);
                    break;

                case 4:
                    deleteMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, 
                    discardedMessages, messageHashes);
                    break;

                case 5:
                    displayAllMessages(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
                    break;

                case 6:
                    displayDiscardedMessages(discardedMessages);
                    break;
                    
                case 7:
                    continueMenu = false;
                    break;

                default:
                    System.out.println("\nInvalid option!");
                    break;
            }
        }
    }

    public static boolean checkMessageID(String messageID, ArrayList<String> messageIDs) {
        if (messageID.length() > 10) {
            System.out.println("\nMessage ID should have 10 characters or less");
            return false;
        }

        if (messageIDs.contains(messageID)) {
            System.out.println("\nMessage ID should be unique");
            return false;
        }

        if (messageID.isEmpty()) {
            System.out.println("\nMessage ID should not be null or empty");
            return false;
        }

        return true;
    }

    public static boolean checkRecipientNumber(String recipientCellNumber) {
        if (recipientCellNumber.length() != 10) {
            System.out.println("\nCell Number is too short or too long");
            return false;
        }

        return true;
    }

    public static String createMessageHash() {
        return Integer.toString((int) (Math.random() * 1000000));
    }

    public static void sendMessage(Scanner input, ArrayList<String> messageIDs, ArrayList<String> messageTexts,
                                   ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages,
                                    ArrayList<String> messageHashes, String messageID,
                                   String messageText, String recipientCellNumber, String messageHash) {
        boolean sendingMessages = true;

        while (sendingMessages) {
            printMessages(messageIDs, messageTexts, recipientCellNumbers, messageHashes);
            System.out.println("\n1. Send Message" +
                            "\n2. Store Message" +
                            "\n3. Discard Message" +
                            "\n4. Continue to send another message" +
                            "\n5. Exit to main menu"
            );

            int messageOption = input.nextInt();
            input.nextLine();

            switch (messageOption) {
                case 1:
                    messageIDs.add(messageID);
                    messageTexts.add(messageText);
                    recipientCellNumbers.add(recipientCellNumber);
                    messageHashes.add(messageHash);
                    System.out.println("\nMessage ID: " + messageID);
                    System.out.println("\nMessage Text: " + messageText);
                    System.out.println("\nRecipient Cellphone Number: " + recipientCellNumber);
                    System.out.println("\nMessage Hash: " + messageHash);
                    System.out.println("\nMessage sent successfully");
                    break;

                case 2:
                    storeMessages(messageID, messageText, recipientCellNumber, messageHash);
                    break;

                case 3:
                    if (!messageTexts.contains(messageText)) {
                        discardedMessages.add(messageText);
                        System.out.println("\nMessage discarded!");
                    } else {
                        System.out.println("\nMessage already sent!");
                    }
                    break;

                case 4:
                    System.out.println("\nProceeding to send another message...");
                    sendingMessages = false; // Exit to continue with next message
                    break;

                case 5:
                    sendingMessages = false;
                    break;
                    
                default:
                    System.out.println("\nInvalid option! Please try again.");
                    break;
            }
        }
    }

    public static void printMessages(ArrayList<String> messageIDs, ArrayList<String> messageTexts,
                                     ArrayList<String> recipientCellNumbers, ArrayList<String> messageHashes) {

        if (!messageTexts.isEmpty()) {
            for (int i = 0; i < messageTexts.size(); i++) {
                System.out.println("\nMessage ID: " + messageIDs.get(i));
                System.out.println("\nMessage Text: " + messageTexts.get(i));
                System.out.println("\nRecipient Cellphone Number: " + recipientCellNumbers.get(i));
                System.out.println("\nMessage Hash: " + messageHashes.get(i));
            }
        } else {
            System.out.println("\nMessages sent!");
        }

    }

    public static int returnTotalMessage(ArrayList<String> messageIDs, ArrayList<String> messageTexts,
                                          ArrayList<String> recipientCellNumbers, ArrayList<String> messageHashes) {
        return messageTexts.size();
    }

    public static void storeMessages(String messageID, String messageText, String recipientCellNumber, String messageHash) {
        // Store message in messages.json file
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        
        try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            // If file doesn't exist or is empty, create new structure
            jsonObject.put("messageid", new JSONArray());
            jsonObject.put("messageText", new JSONArray());
            jsonObject.put("recipientCellNumber", new JSONArray());
            jsonObject.put("messageHash", new JSONArray());
        }
        
        // Get existing arrays
        JSONArray messageIds = (JSONArray) jsonObject.get("messageid");
        JSONArray messageTexts = (JSONArray) jsonObject.get("messageText");
        JSONArray recipientCellNumbers = (JSONArray) jsonObject.get("recipientCellNumber");
        JSONArray messageHashes = (JSONArray) jsonObject.get("messageHash");
        
        // Add new message data
        messageIds.add(messageID);
        messageTexts.add(messageText);
        recipientCellNumbers.add(recipientCellNumber);
        messageHashes.add(messageHash);
        
        // Write back to file
        try (java.io.FileWriter writer = new java.io.FileWriter("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            writer.write(jsonObject.toJSONString());
            writer.flush();
            System.out.println("\nMessage stored successfully!");
        } catch (Exception e) {
            System.out.println("\nError storing message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Reads messages.json and prints the messages and discardedMessages arrays
    public static void readMessagesFromJson() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray messageIds = (JSONArray) obj.get("messageid");
            JSONArray messageTexts = (JSONArray) obj.get("messageText");
            JSONArray recipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
            JSONArray messageHashes = (JSONArray) obj.get("messageHash");

            System.out.println("Stored Messages:");
            if (messageIds != null && !messageIds.isEmpty()) {
                for (int i = 0; i < messageIds.size(); i++) {
                    System.out.println("Message ID: " + messageIds.get(i));
                    System.out.println("Message Text: " + messageTexts.get(i));
                    System.out.println("Recipient Cell Number: " + recipientCellNumbers.get(i));
                    System.out.println("Message Hash: " + messageHashes.get(i));
                    System.out.println("---");
                }
            } else {
                System.out.println("No messages found.");
            }
        } catch (Exception e) {
            System.out.println("Error reading messages: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void viewSentMessagesOfSenderAndReceipient(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {

        // Read from JSON file
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
            JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
            JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
            JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
            
            if (jsonMessageIds != null && !jsonMessageIds.isEmpty()) {
                for (int i = 0; i < jsonMessageIds.size(); i++) {
                    System.out.println("\nSender Cell Number: " + user1.getCellPhoneNumber());
                    System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                    System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                    System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                    System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                    System.out.println("---");
                }
            } else {
                System.out.println("\nNo messages found!");
            }
        } catch (Exception e) {
            System.out.println("Error reading messages: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void displayLongestSentMessage(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {

        // Read from JSON file
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
            JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
            JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
            JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
            
            if (jsonMessageTexts != null && !jsonMessageTexts.isEmpty()) {
                String longestMessage = (String) jsonMessageTexts.get(0);
                int longestIndex = 0;
                
                for (int i = 1; i < jsonMessageTexts.size(); i++) {
                    String currentMessage = (String) jsonMessageTexts.get(i);
                    if (currentMessage.length() > longestMessage.length()) {
                        longestMessage = currentMessage;
                        longestIndex = i;
                    }
                }
                
                System.out.println("\nLongest Sent Message: " + longestMessage);
                System.out.println("\nSender Cell Number: " + user1.getCellPhoneNumber());
                System.out.println("\nMessage ID: " + jsonMessageIds.get(longestIndex));
                System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(longestIndex));
                System.out.println("\nMessage Hash: " + jsonMessageHashes.get(longestIndex));
            } else {
                System.out.println("\nNo messages found!");
            }
        } catch (Exception e) {
            System.out.println("Error reading messages: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void searchMessage(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {
        System.out.println("\n1.Search by message ID" +
                            "\n2.Search by receipient cell number" +
                            "\n3.Exit"
        );

        int searchOption = input.nextInt();
        input.nextLine(); // Consume newline

        switch (searchOption) {
            case 1:
                System.out.println("\nEnter message ID to search: ");
                String searchMessageId = input.nextLine();
                // read from json file
                JSONParser parser1 = new JSONParser();
                try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                    JSONObject obj = (JSONObject) parser1.parse(reader);
                    JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
                    JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
                    JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
                    JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
                    
                    boolean found = false;
                    for (int i = 0; i < jsonMessageIds.size(); i++) {
                        if (jsonMessageIds.get(i).equals(searchMessageId)) {
                            System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                            System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                            System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                            System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nMessage ID not found!");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading messages: " + e.getMessage());
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("\nEnter recipient cell number to search: ");
                String searchRecipientNumber = input.nextLine();
                // read from json file
                JSONParser parser2 = new JSONParser();
                try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                    JSONObject obj = (JSONObject) parser2.parse(reader);
                    JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
                    JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
                    JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
                    JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
                    
                    boolean found = false;
                    for (int i = 0; i < jsonRecipientCellNumbers.size(); i++) {
                        if (jsonRecipientCellNumbers.get(i).equals(searchRecipientNumber)) {
                            System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                            System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                            System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                            System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("\nNo messages found for this recipient!");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading messages: " + e.getMessage());
                    e.printStackTrace();
                }
                break;

            case 3:
                break;

            default:
                System.out.println("\nInvalid option!");
                break;
        }
    }

    public static void deleteMessage(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {
        System.out.println("\n1.Delete by message Hash" +
                            "\n2.Delete by receipient cell number" +
                            "\n3.Exit"
        );

        int deleteOption = input.nextInt();
        input.nextLine(); // Consume newline

        switch (deleteOption) {
            case 1:
                System.out.println("\nEnter message hash to delete: ");
                String deleteMessageHash = input.nextLine();
                // read from json file
                JSONParser parser1 = new JSONParser();
                try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                    JSONObject obj = (JSONObject) parser1.parse(reader);
                    JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
                    JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
                    JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
                    JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
                    
                    boolean found = false;
                    for (int i = 0; i < jsonMessageHashes.size(); i++) {
                        if (jsonMessageHashes.get(i).equals(deleteMessageHash)) {
                            System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                            System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                            System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                            System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                            System.out.println("\nMessage found and will be deleted.");
                            
                            // Remove the message from all arrays
                            jsonMessageIds.remove(i);
                            jsonMessageTexts.remove(i);
                            jsonRecipientCellNumbers.remove(i);
                            jsonMessageHashes.remove(i);
                            
                            // Write back to file
                            try (java.io.FileWriter writer = new java.io.FileWriter("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                                writer.write(obj.toJSONString());
                                writer.flush();
                                System.out.println("\nMessage deleted successfully!");
                            } catch (Exception e) {
                                System.out.println("\nError deleting message: " + e.getMessage());
                            }
                            
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nMessage hash not found!");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading messages: " + e.getMessage());
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("\nEnter recipient cell number to delete messages: ");
                String deleteRecipientNumber = input.nextLine();
                // read from json file
                JSONParser parser2 = new JSONParser();
                try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                    JSONObject obj = (JSONObject) parser2.parse(reader);
                    JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
                    JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
                    JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
                    JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
                    
                    boolean found = false;
                    // Delete from end to beginning to avoid index issues
                    for (int i = jsonRecipientCellNumbers.size() - 1; i >= 0; i--) {
                        if (jsonRecipientCellNumbers.get(i).equals(deleteRecipientNumber)) {
                            System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                            System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                            System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                            System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                            System.out.println("\nMessage found and will be deleted.");
                            
                            // Remove the message from all arrays
                            jsonMessageIds.remove(i);
                            jsonMessageTexts.remove(i);
                            jsonRecipientCellNumbers.remove(i);
                            jsonMessageHashes.remove(i);
                            
                            found = true;
                        }
                    }
                    
                    if (found) {
                        // Write back to file
                        try (java.io.FileWriter writer = new java.io.FileWriter("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
                            writer.write(obj.toJSONString());
                            writer.flush();
                            System.out.println("\nMessages deleted successfully!");
                        } catch (Exception e) {
                            System.out.println("\nError deleting messages: " + e.getMessage());
                        }
                    } else {
                        System.out.println("\nNo messages found for this recipient!");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading messages: " + e.getMessage());
                    e.printStackTrace();
                }
                break;

            case 3:
                break;

            default:
                System.out.println("\nInvalid option!");
                break;
        }
    }

    public static void displayAllMessages(Scanner input, User user1, ArrayList<String> messageIDs, 
    ArrayList<String> messageTexts, ArrayList<String> recipientCellNumbers, ArrayList<String> discardedMessages, 
    ArrayList<String> messageHashes) {
        System.out.println("\nAll messages:");
        
        // Read from JSON file
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/com/mycompany/chat_app_poe_part3/messages.json")) {
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray jsonMessageIds = (JSONArray) obj.get("messageid");
            JSONArray jsonMessageTexts = (JSONArray) obj.get("messageText");
            JSONArray jsonRecipientCellNumbers = (JSONArray) obj.get("recipientCellNumber");
            JSONArray jsonMessageHashes = (JSONArray) obj.get("messageHash");
            
            if (jsonMessageIds != null && !jsonMessageIds.isEmpty()) {
                for (int i = 0; i < jsonMessageIds.size(); i++) {
                    System.out.println("\nMessage ID: " + jsonMessageIds.get(i));
                    System.out.println("\nMessage Text: " + jsonMessageTexts.get(i));
                    System.out.println("\nRecipient Cell Number: " + jsonRecipientCellNumbers.get(i));
                    System.out.println("\nMessage Hash: " + jsonMessageHashes.get(i));
                    System.out.println("---");
                }
            } else {
                System.out.println("\nNo messages found in storage.");
            }
        } catch (Exception e) {
            System.out.println("Error reading messages: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void displayDiscardedMessages(ArrayList<String> discardedMessages) {
        if (discardedMessages != null && !discardedMessages.isEmpty()) {
            for (int i = 0; i < discardedMessages.size(); i++) {
                System.out.println("\n" + discardedMessages.get(i));
                System.out.println("---");
            }
        } else {
            System.out.println("\nNo messages were discarded.");
        }
    }
}
