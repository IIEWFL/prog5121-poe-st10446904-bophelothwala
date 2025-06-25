/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chat_app_poe_part3;

import java.util.ArrayList;
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
public class MessageTest {
    
    public MessageTest() {
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
     * Test of start method, of class Message.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Scanner input = null;
        User user1 = null;
        Message instance = new Message();
        instance.start(input, user1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of message method, of class Message.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        Scanner input = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.message(input, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of recentlySentMessages method, of class Message.
     */
    @Test
    public void testRecentlySentMessages() {
        System.out.println("recentlySentMessages");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.recentlySentMessages(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageID = "";
        ArrayList<String> messageIDs = null;
        boolean expResult = true;
        boolean result = Message.checkMessageID(messageID, messageIDs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkRecipientNumber method, of class Message.
     */
    @Test
    public void testCheckRecipientNumber() {
        System.out.println("checkRecipientNumber");
        String recipientCellNumber = "+277902410";
        boolean expResult = true;
        boolean result = Message.checkRecipientNumber(recipientCellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String expResult = "";
        String result = Message.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Scanner input = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        String messageID = "";
        String messageText = "Hi Mike, can you join us for dinner tonight";
        String recipientCellNumber = "+277186930";
        String messageHash = "";
        Message.sendMessage(input, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes, messageID, messageText, recipientCellNumber, messageHash);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> messageHashes = null;
        Message.printMessages(messageIDs, messageTexts, recipientCellNumbers, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of returnTotalMessage method, of class Message.
     */
    @Test
    public void testReturnTotalMessage() {
        System.out.println("returnTotalMessage");
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> messageHashes = null;
        int expResult = 1;
        int result = Message.returnTotalMessage(messageIDs, messageTexts, recipientCellNumbers, messageHashes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of storeMessages method, of class Message.
     */
    @Test
    public void testStoreMessages() {
        System.out.println("storeMessages");
        String messageID = "";
        String messageText = "Hi Mike, can you join us for dinner tonight";
        String recipientCellNumber = "+277186930";
        String messageHash = "";
        Message.storeMessages(messageID, messageText, recipientCellNumber, messageHash);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of readMessagesFromJson method, of class Message.
     */
    @Test
    public void testReadMessagesFromJson() {
        System.out.println("readMessagesFromJson");
        Message.readMessagesFromJson();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of viewSentMessagesOfSenderAndReceipient method, of class Message.
     */
    @Test
    public void testViewSentMessagesOfSenderAndReceipient() {
        System.out.println("viewSentMessagesOfSenderAndReceipient");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.viewSentMessagesOfSenderAndReceipient(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayLongestSentMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestSentMessage() {
        System.out.println("displayLongestSentMessage");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.displayLongestSentMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of searchMessage method, of class Message.
     */
    @Test
    public void testSearchMessage() {
        System.out.println("searchMessage");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.searchMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteMessage method, of class Message.
     */
    @Test
    public void testDeleteMessage() {
        System.out.println("deleteMessage");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.deleteMessage(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayAllMessages method, of class Message.
     */
    @Test
    public void testDisplayAllMessages() {
        System.out.println("displayAllMessages");
        Scanner input = null;
        User user1 = null;
        ArrayList<String> messageIDs = null;
        ArrayList<String> messageTexts = null;
        ArrayList<String> recipientCellNumbers = null;
        ArrayList<String> discardedMessages = null;
        ArrayList<String> messageHashes = null;
        Message.displayAllMessages(input, user1, messageIDs, messageTexts, recipientCellNumbers, discardedMessages, messageHashes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of displayDiscardedMessages method, of class Message.
     */
    @Test
    public void testDisplayDiscardedMessages() {
        System.out.println("displayDiscardedMessages");
        ArrayList<String> discardedMessages = null;
        Message.displayDiscardedMessages(discardedMessages);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
