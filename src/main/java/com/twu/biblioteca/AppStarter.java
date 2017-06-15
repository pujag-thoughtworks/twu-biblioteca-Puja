package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.util.ArrayList;

/**
 * Creates all necessary objects and calls required methods
 */
public class AppStarter  {

    ConsoleWriter consoleWriter;

    AppStarter(ConsoleWriter consoleWriter) {
        this.consoleWriter=consoleWriter;
    }

    public void start(String welcomeMessage, ArrayList<Book> bookList) {

        consoleWriter.write(welcomeMessage);
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(bookList);
        listAvailableBooks.displayAvailableBooks(consoleWriter);

    }
}
