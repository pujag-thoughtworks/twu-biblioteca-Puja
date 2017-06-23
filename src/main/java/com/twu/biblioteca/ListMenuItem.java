package com.twu.biblioteca;

import com.twu.buildingBlocks.Item;
import com.twu.inputOutput.OutputWriter;

import java.util.List;

/**
 * List the available books with the necessary details
 */
public class ListMenuItem<T extends Item> implements MenuItem {

    public static final String MENU_NAME = "List";

    private OutputWriter outputWriter;
    private List<T> itemList;
    private String itemName;

    ListMenuItem(OutputWriter outputWriter, Inventory<T> inventory) {
        this.outputWriter = outputWriter;
        itemList = inventory.getAvailableItems();
    }

    public void setItemName(String itemName) {
        this.itemName=itemName;
    }

    public void performAction() {
        outputWriter.write("Available " +itemName +" are:");
        for (T item: itemList)
            outputWriter.write(item.toString());
    }


    @Override
    public String getMenuName() {
        return MENU_NAME + " " + itemName;
    }

}
