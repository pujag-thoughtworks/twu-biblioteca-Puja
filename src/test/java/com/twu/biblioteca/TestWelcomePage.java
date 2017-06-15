package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * Created by pujag on 6/15/17.
 */
public class TestWelcomePage extends WelcomePage {
    boolean isWrittenToConsole;
    TestWelcomePage(String message) {
        super(message);
    }

    @Override
    public void writeWelcomeMessage(OutputWriter outputWriter) {
        isWrittenToConsole=true;
    }

    public boolean isWelcomeMessageWritten() {
        return isWrittenToConsole;
    }

}
