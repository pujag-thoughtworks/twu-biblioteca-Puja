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

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void writeWelcomeMessage(OutputWriter outputWriter ) {
        outputWriter.write(welcomeMessage);

    }
}
