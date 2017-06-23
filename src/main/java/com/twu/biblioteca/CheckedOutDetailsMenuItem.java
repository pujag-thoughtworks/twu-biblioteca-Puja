package com.twu.biblioteca;

import com.twu.buildingBlocks.Customer;
import com.twu.buildingBlocks.Item;
import com.twu.inputOutput.OutputWriter;

import java.util.Map;

/**
 * Class that displays the checked out item details to the librarian
 */
public class CheckedOutDetailsMenuItem<T extends Item> implements MenuItem {
    public static final String MENU_NAME =" View Checked out";
    private static final String NO_CHECK_OUTS="No items are checked out";
    private OutputWriter outputWriter;
    private Inventory<T> inventory;
    private String itemName;

    CheckedOutDetailsMenuItem(OutputWriter outputWriter, Inventory<T> inventory) {
        this.outputWriter = outputWriter;
        this.inventory = inventory;
    }

    @Override
    public void performAction() {
        Map<T, Customer> checkedOutItemsMap = inventory.getCheckOutDetails();
        if(checkedOutItemsMap.isEmpty())
            outputWriter.write(NO_CHECK_OUTS);
        for (Map.Entry<T, Customer> entry : checkedOutItemsMap.entrySet()) {
            T item = entry.getKey();
            Customer customer = entry.getValue();
            String output = item.getName() + " " + customer.getLibraryNo();
            outputWriter.write(output);
        }

    }
    public void setItemName(String itemName) {
        this.itemName=itemName;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME + " " + itemName;
    }
}
