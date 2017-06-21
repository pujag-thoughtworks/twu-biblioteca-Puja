package com.twu.mockModels;

import com.twu.resources.BookStorage;
import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock class to store outputs
 * Created to facilitate testing
 * Reduces the need of creating same output repeatedly
 */
public class ExpectedOutput {

    public List<String> getMenuDisplayOutput(List<MenuItem> menuList) {
        List<String> output = new ArrayList<>();
        output.add(Menu.DISPLAY_MESSAGE);
        int index=1;
        for(MenuItem menuItem:menuList) {
            output.add(index+ ") " +menuItem.getMenuName());
            index++;
        }
        output.add(Menu.MESSAGE_TO_REQUEST_INPUT);
        return output;
    }

    public List<String> getListBooksOutput() {
        List<String> output = new ArrayList<>();
        output.add(Constants.LIST_BOOK_DESCRIPTION_MESSAGE);
        BookStorage bookStorage = new BookStorage();
        for (Book book : bookStorage.getBookList())
            output.add(book.toString());
        return output;
    }


}
