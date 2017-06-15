package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * Structure of welcome page
 */
public class WelcomePage {

    private String welcomeMessage;

    WelcomePage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void writeWelcomeMessage(OutputWriter outputWriter ) {
        outputWriter.write(welcomeMessage);

    }
}
