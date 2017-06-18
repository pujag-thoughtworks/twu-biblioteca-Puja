package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * Menu item for quitting from the application
 */
public class QuitMenuItem implements MenuItem {

    OutputWriter outputWriter;
    static final String QUIT_MESSAGE = "Thank you for using Biblioteca :)\n";
    public static final String MENU_NAME = "Quit Biblioteca";

    QuitMenuItem(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    @Override
    public void performAction() {
        outputWriter.write(QUIT_MESSAGE);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
