package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * MenuItem to facilitate check-out of books.
 */
public class CheckOutMenuItem<ItemType extends Item> implements MenuItem {

    public static final String MENU_NAME = "Check out ";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Inventory<ItemType> inventory;

    private String messageToRequestCheckout;
    private String unsuccessfulCheckoutMessage;
    private String successfulCheckoutMessage;

    CheckOutMenuItem(InputReader inputReader, OutputWriter outputWriter, Inventory<ItemType> inventory, Customer customer) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inventory = inventory;
    }

    void setDisplayMessage(String requestCheckoutMsg,String unsuccessfulCheckoutMsg, String successfulCheckoutMsg) {
        messageToRequestCheckout=requestCheckoutMsg;
        unsuccessfulCheckoutMessage=unsuccessfulCheckoutMsg;
        successfulCheckoutMessage=successfulCheckoutMsg;
    }

    @Override
    public void performAction() {

        outputWriter.write(messageToRequestCheckout);
        String itemName = inputReader.read();
        if (!inventory.isItemAvailableForCheckout(itemName)) {
            outputWriter.write(unsuccessfulCheckoutMessage);
            return;
        }
        inventory.checkoutItem(itemName);
        outputWriter.write(successfulCheckoutMessage);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

}
