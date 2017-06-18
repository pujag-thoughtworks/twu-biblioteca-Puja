package com.twu.mockModels;

import com.twu.Resources.BookStorage;
import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujag on 6/18/17.
 */
public class ExpectedOutput {

    public List<String> getMenuDisplayOutput() {
        List<String> output = new ArrayList<>();
        output.add(MainMenu.DISPLAY_MESSAGE);
        output.add(1 + ") " + ListBooksMenuItem.MENU_NAME);
        output.add(2 + ") " + CheckOutBookMenuItem.MENU_NAME);
        output.add(3 + ") " + ReturnBookMenuItem.MENU_NAME);
        output.add(4 + ") " + QuitMenuItem.MENU_NAME);
        output.add(MainMenu.MESSAGE_TO_REQUEST_INPUT);
        return output;
    }

    public List<String> getListBooksOutput() {
        List<String> output = new ArrayList<>();
        BookStorage bookStorage = new BookStorage();
        for (Book book : bookStorage.getBookList())
            output.add(book.toString());
        return output;
    }


}
