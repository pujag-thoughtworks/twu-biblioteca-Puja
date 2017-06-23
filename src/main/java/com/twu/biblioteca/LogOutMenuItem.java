package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * menu item for logging out from account specific menu.
 * It is used for both customer as well as librarian specific logout.
 */
public class LogOutMenuItem implements MenuItem {


    public static final String LOG_OUT_MESSAGE="Successfully logged out";
    public static final String MENU_NAME ="Log out" ;

    private OutputWriter outputWriter;

    public LogOutMenuItem(OutputWriter outputWriter) {
        this.outputWriter=outputWriter;
    }

    @Override
    public void performAction() {
        outputWriter.write(LOG_OUT_MESSAGE);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
