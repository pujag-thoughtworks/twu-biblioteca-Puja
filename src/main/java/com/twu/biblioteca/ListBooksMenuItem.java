package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.inputOutput.OutputWriter;

import java.util.List;

/**
 * List the available books with the necessary details
 */
public class ListBooksMenuItem implements MenuItem {

    private final String MENU_NAME="List available books";
    private OutputWriter outputWriter;
    private List<Book> bookList;

    public ListBooksMenuItem(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        BookStorage bookStorage = new BookStorage();
        bookList = bookStorage.getBookList();
    }


    public void performAction() {
        for (Book book : bookList)
            outputWriter.write(book.toString());
    }

    public String getMenuName() {
        return MENU_NAME;
    }
}
