package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Created by pujag on 6/21/17.
 */
public class LibrarianLoginMenuItem  implements MenuItem{
    public LibrarianLoginMenuItem(InputReader inputReader, OutputWriter outputWriter) {
    }

    @Override
    public void performAction() {

    }

    @Override
    public String getMenuName() {
        return Constants.LIBRARIAN_LOGIN_MENU_NAME;
    }
}
