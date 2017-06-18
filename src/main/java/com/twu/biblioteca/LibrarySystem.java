package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Creates all necessary objects and calls required methods
 */
class LibrarySystem {

    static final String WELCOME_MESSAGE = "\nWELCOME TO BIBLIOTECA";

    private OutputWriter outputWriter;
    private MainMenu mainMenu;

    LibrarySystem(InputReader inputReader, OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        mainMenu = new MainMenu(inputReader, outputWriter);
    }

    void start() {
        outputWriter.write(WELCOME_MESSAGE);
        mainMenu.displayMenu();
        mainMenu.performSelectedAction();

    }

}
