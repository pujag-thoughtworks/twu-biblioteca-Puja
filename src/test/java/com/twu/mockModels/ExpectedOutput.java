package com.twu.mockModels;

import com.twu.Resources.BookStorage;
import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Expected output to check output of test cases.
 */
public class ExpectedOutput {

    private String DISPLAY_MESSAGE = MainMenu.DISPLAY_MESSAGE;
    BookStorage bookList = new BookStorage();

    public List getOutputForLisBooksMenuItems() {
        ArrayList<String> displayedBookList = new ArrayList<>();
        for (Book book : bookList.getBookList()) {
            displayedBookList.add(book.toString());
        }
        return displayedBookList;
    }

    public List getOutputForMainMenuDispaly() {
        ArrayList<String> displayedMenu = new ArrayList<>();
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(new TestInputReader("1"), testOutputWriter);
        mainMenu.addMenuItems(new ListBooksMenuItem(testOutputWriter));
        mainMenu.display();
        displayedMenu.addAll(testOutputWriter.getOutput());
        return displayedMenu;
    }


}
