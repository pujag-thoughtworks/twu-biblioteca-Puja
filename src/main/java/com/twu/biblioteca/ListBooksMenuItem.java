package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

import java.util.List;

/**
 * List the available books with the necessary details
 */
public class ListBooksMenuItem implements MenuItem {

    public static final String MENU_NAME = "List available books";
    public static final String MENU_DESCRIPTION_MESSAGE = "Available books are:\n";
    private OutputWriter outputWriter;
    private List<Book> bookList;

    ListBooksMenuItem(OutputWriter outputWriter, Librarian librarian) {
        this.outputWriter = outputWriter;
        bookList = librarian.getAvailableBooks();
    }

    public void performAction() {
        outputWriter.write(MENU_DESCRIPTION_MESSAGE);
        for (Book book : bookList)
            outputWriter.write(book.toString());
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

}
