package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * MenuItem to facilitate check-out of books.
 */
public class CheckOutMenuItem<T extends Item> implements MenuItem {

    public static final String MENU_NAME = "Check out";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Inventory<T> inventory;
    private Customer loggedInCustomer;
    private String itemName;

    public static final  String MESSAGE_TO_CHECKOUT="Please enter the item name for check-out";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE ="The required item is not available" ;
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE ="Thank you! Enjoy your selection" ;

    CheckOutMenuItem(InputReader inputReader, OutputWriter outputWriter, Inventory<T> inventory, Customer customer) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inventory = inventory;
        this.loggedInCustomer=customer;
    }

    @Override
    public void performAction() {

        outputWriter.write(MESSAGE_TO_CHECKOUT);
        String itemName = inputReader.read();
        if (!inventory.isItemAvailableForCheckout(itemName)) {
            outputWriter.write(UNSUCCESSFUL_CHECKOUT_MESSAGE);
            return;
        }
        inventory.checkoutItem(itemName,loggedInCustomer);
        outputWriter.write(SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    public void setItemType(String itemName) {
        this.itemName=itemName;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME + " " + itemName ;
    }

}
