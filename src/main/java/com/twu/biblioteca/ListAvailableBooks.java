package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.util.ArrayList;

/**
 * List the available books with the necessary details
 */
public class ListAvailableBooks {

    ArrayList<Book> bookList;

    public ListAvailableBooks(ArrayList<Book> bookList) {
        this.bookList=bookList;
    }


    public void displayAvailableBooks(ConsoleWriter consoleWriter) {
        for(Book book:bookList)
            consoleWriter.write(book.toString());
    }
}
