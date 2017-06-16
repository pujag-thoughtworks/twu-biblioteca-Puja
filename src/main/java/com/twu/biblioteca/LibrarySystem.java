package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Creates all necessary objects and calls required methods
 */
public class LibrarySystem {

    private OutputWriter outputWriter;
    private InputReader inputReader;
    public static final String WELCOME_MESSAGE = "WELCOME TO BIBLIOTECA \n";

    LibrarySystem(InputReader inputReader, OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void start() {
        outputWriter.write(WELCOME_MESSAGE);
        MainMenu menu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        menu.addMenuItems(listBooksMenuItem);
        menu.display();
        menu.performSelectedAction();

    }

}
