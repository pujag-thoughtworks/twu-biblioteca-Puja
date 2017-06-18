package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.inputOutput.OutputWriter;

import java.util.List;

/**
 * List the available books with the necessary details
 */
public class ListBooksMenuItem implements MenuItem {

    public static final String MENU_NAME="List available books";
    public static final String MENU_DESCRIPTION_MESSAGE="Available books are:";
    Librarian librarian;
    private OutputWriter outputWriter;
    private List<Book> bookList;

    public ListBooksMenuItem(OutputWriter outputWriter, Librarian librarian) {
        this.outputWriter = outputWriter;
        this.librarian=librarian;
        bookList = librarian.getAvailableBooks();
    }

    public void performAction() {
        for (Book book : bookList)
            outputWriter.write(book.toString());
    }

    public String getMenuName() {
        return MENU_NAME;
    }
}
