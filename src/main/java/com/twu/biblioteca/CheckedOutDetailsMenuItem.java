package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

import java.util.Map;

/**
 * Created by pujag on 6/21/17.
 */
public class CheckedOutDetailsMenuItem<T extends Item> implements MenuItem {
    private OutputWriter outputWriter;
    private Inventory<T> inventory;

    CheckedOutDetailsMenuItem(OutputWriter outputWriter, Inventory<T> inventory) {
        this.outputWriter = outputWriter;
        this.inventory = inventory;
    }

    @Override
    public void performAction() {
        Map<T, Customer> checkedOutItemsMap = inventory.getCheckOutDetails();
        for (Map.Entry<T, Customer> entry : checkedOutItemsMap.entrySet()) {
            T item = entry.getKey();
            Customer customer = entry.getValue();
            String output = item.getName() + " " + customer.getLibraryNo();
            outputWriter.write(output);
        }

    }

    @Override
    public String getMenuName() {
        return Constants.CHECKED_OUT_DETAILS_MENU_NAME;
    }
}
