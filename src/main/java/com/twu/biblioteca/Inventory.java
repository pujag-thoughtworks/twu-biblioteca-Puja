package com.twu.biblioteca;

import com.twu.resources.BookStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to handle internal details of library.
 * It maintains information about book availability and what are the books belonging to library.
 */
class Inventory<ItemType extends Item> {


    private Map<String, ItemType> titleToItem;
    private List<ItemType> availableItems;

    Inventory(List<ItemType> availableItems) {
        titleToItem=new HashMap<>();
        this.availableItems = availableItems;
        for (ItemType item : availableItems) {
            String itemName = item.getName().toLowerCase();
            titleToItem.put(itemName, item);
        }
    }

    boolean isItemAvailableForCheckout(String itemName) {
        String formattedItemName = itemName.toLowerCase();
        ItemType requestedItem = titleToItem.getOrDefault(formattedItemName, null);

        return !(requestedItem == null || !availableItems.contains(requestedItem));
    }

    boolean doesItemBelongsToLibrary(String itemName) {
        String formattedItemName = itemName.toLowerCase();
        if (!titleToItem.containsKey(formattedItemName))
            return false;
        ItemType itemToReturn = titleToItem.get(formattedItemName);
        return !availableItems.contains(itemToReturn);
    }

    void checkoutItem(String itemName) {
        ItemType requestedItem = titleToItem.get(itemName.toLowerCase());
        availableItems.remove(requestedItem);
    }

    void returnItem(String itemName) {
        ItemType itemToReturn = titleToItem.get(itemName.toLowerCase());
        availableItems.add(itemToReturn);
    }

    List<ItemType> getAvailableItems() {
        return availableItems;
    }

}
