package com.twu.resources;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;

import java.util.List;

/**
 * Generic class to retrieve
 */
public class Storage<T extends Item> {
    private List<T> itemList;

    Storage(List<T> itemList) {
        this.itemList = itemList;
    }

    public List<T> getItemList() {
        return itemList;
    }
}




