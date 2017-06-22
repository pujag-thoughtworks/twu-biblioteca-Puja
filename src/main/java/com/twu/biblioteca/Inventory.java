package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to handle internal details of library.
 * It maintains information about book availability and what are the books belonging to library.
 */
class Inventory<T extends Item> {

    private Map<String, T> titleToItem;
    private Map<T, Customer> itemToCustomer;
    private List<T> availableItems;

    Inventory(List<T> availableItems) {
        titleToItem = new HashMap<>();
        itemToCustomer = new HashMap<>();
        this.availableItems = availableItems;
        for (T item : availableItems) {
            String itemName = item.getName().toLowerCase();
            titleToItem.put(itemName, item);
        }
    }

    boolean isItemAvailableForCheckout(String itemName) {
        String formattedItemName = itemName.toLowerCase();
        T requestedItem = titleToItem.getOrDefault(formattedItemName, null);

        return !(requestedItem == null || itemToCustomer.containsKey(requestedItem));
    }

    boolean doesItemBelongsToLibrary(String itemName) {
        String formattedItemName = itemName.toLowerCase();
        if (!titleToItem.containsKey(formattedItemName))
            return false;
        T itemToReturn = titleToItem.get(formattedItemName);
        return !availableItems.contains(itemToReturn);
    }

    void checkoutItem(String itemName, Customer loggedInCustomer) {
        T requestedItem = titleToItem.get(itemName.toLowerCase());
        itemToCustomer.put(requestedItem, loggedInCustomer);
        availableItems.remove(requestedItem);
    }


    void returnItem(String itemName, Customer loggedInCustomer) {
        T itemToReturn = titleToItem.get(itemName.toLowerCase());
        availableItems.add(itemToReturn);
        itemToCustomer.remove(itemToReturn, loggedInCustomer);
    }

    List<T> getAvailableItems() {
        return availableItems;
    }

    Map<T, Customer> getCheckOutDetails() {
        return itemToCustomer;
    }



}
