package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * Creates all necessary objects and calls required methods
 */
public class AppStarter  {

    private WelcomePage welcomePage;

    public AppStarter(WelcomePage welcomePage) {
        this.welcomePage=welcomePage;
    }

    public void start() {
        ConsoleWriter consoleWriter=new ConsoleWriter(new BufferedWriter(new
                OutputStreamWriter(System.out)));
        welcomePage.writeWelcomeMessage(consoleWriter);
    }
}
