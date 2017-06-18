package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Creates all necessary objects and calls required methods
 */
public class LibrarySystem {

    public static final String WELCOME_MESSAGE="WELCOME TO BIBLIOTECA\n";

    InputReader inputReader;
    OutputWriter outputWriter;
    MainMenu mainMenu;

    LibrarySystem(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        mainMenu = new MainMenu(inputReader, outputWriter);
    }

    public void start() {
        outputWriter.write(WELCOME_MESSAGE);
        mainMenu.displayMenu();
        mainMenu.performSelectedAction();

    }
}
