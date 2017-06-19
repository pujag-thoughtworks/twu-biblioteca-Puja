package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

import java.util.List;

/**
 * List the available books with the necessary details
 */
public class ListMenuItem<ItemType extends Item> implements MenuItem {

    public static final String MENU_NAME = "List";

    private String descriptionMessage;
    private OutputWriter outputWriter;
    private List<ItemType> itemList;

    ListMenuItem(OutputWriter outputWriter, Inventory<ItemType> inventory) {
        this.outputWriter = outputWriter;
        itemList = inventory.getAvailableItems();
    }

    public void setDescriptionMessage(String message) {
        descriptionMessage=message;
    }

    public void performAction() {
        outputWriter.write(descriptionMessage);
        for (ItemType item: itemList)
            outputWriter.write(item.toString());
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

}
