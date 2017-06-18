package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * created to map invalid menu selection by the user.
 */
class InvalidMenuItem implements MenuItem {

    static final String OPTION_INVALID_MESSAGE = "Select a valid option!\n";
    OutputWriter outputWriter;

    InvalidMenuItem(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    @Override
    public void performAction() {
        outputWriter.write(OPTION_INVALID_MESSAGE);
    }

    @Override
    public String getMenuName() {
        return null;
    }

}
