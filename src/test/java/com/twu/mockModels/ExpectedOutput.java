package com.twu.mockModels;

import com.twu.Resources.BookStorage;
import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Expected output to check output of test cases.
 */
public class ExpectedOutput {

    BookStorage bookList = new BookStorage();

    public List getOutputForListBooksMenuItems() {
        ArrayList<String> displayedBookList = new ArrayList<>();
        for (Book book : bookList.getBookList()) {
            displayedBookList.add(book.toString());
        }
        return displayedBookList;
    }

    public List getOutputForMainMenuDispaly(String[] menuNames) {
        ArrayList<String> displayedMenu = new ArrayList<>();
        displayedMenu.add(MainMenu.DISPLAY_MESSAGE);
        for (int index = 0; index < menuNames.length; index++) {
            String formattedName = index + 1 + ") " + menuNames[index];
            displayedMenu.add(formattedName);
        }
        return displayedMenu;
    }


}
