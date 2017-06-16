package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Creates all necessary objects and calls required methods
 */
public class AppStarter {

    private OutputWriter outputWriter;
    private InputReader inputReader;
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca";

    AppStarter(InputReader inputReader,OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void start() {

        outputWriter.write(WELCOME_MESSAGE);

        MainMenu menu = new MainMenu(inputReader,outputWriter);
        ListAvailableBooks listAvailableBooks = new ListAvailableBooks(outputWriter);
        menu.addMenuItems(listAvailableBooks);
        menu.display();
        menu.loadSelectedMenu();


    }
}
