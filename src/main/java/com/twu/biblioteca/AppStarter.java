package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.inputOutput.ConsoleWriter;

/**
 * Creates all necessary objects and calls required methods
 */
public class AppStarter  {

    ConsoleWriter consoleWriter;

    AppStarter(ConsoleWriter consoleWriter) {
        this.consoleWriter=consoleWriter;
    }

    public void start() {

        consoleWriter.write("Welcome to Biblioteca");
        BookStorage bookList=new BookStorage();
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(bookList.getBookList());
        listAvailableBooks.displayAvailableBooks(consoleWriter);

    }
}
