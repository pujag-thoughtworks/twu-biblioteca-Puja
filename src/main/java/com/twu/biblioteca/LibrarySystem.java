package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Creates all necessary objects and calls required methods
 */
class LibrarySystem {

    static final String WELCOME_MESSAGE = "\nWELCOME TO BIBLIOTECA";

    private OutputWriter outputWriter;
    private Menu menu;

    LibrarySystem(InputReader inputReader, OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        MenuProvider menuProvider=new MenuProvider(inputReader,outputWriter);
        menu = new Menu(inputReader, outputWriter,menuProvider.provideMenu());
    }

    void start() {
        outputWriter.write(WELCOME_MESSAGE);
        menu.displayMenu();
        menu.performSelectedAction();

    }

}
