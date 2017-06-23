package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Librarian login page
 */
public class LibrarianLoginMenuItem  implements MenuItem{

    static final String LIBRARIAN_LOGIN_MENU_NAME = "Librarian Login Menu";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private MenuProvider menuProvider;
    private UserAuthentication userAuthentication;


    public LibrarianLoginMenuItem(InputReader inputReader, OutputWriter outputWriter,MenuProvider menuProvider) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.menuProvider = menuProvider;
        this.userAuthentication=new UserAuthentication(inputReader,outputWriter);
    }

    @Override
    public void performAction() {
        User loggedInUser = userAuthentication.authenticateUser(Librarian.USER_TYPE);
        if (loggedInUser == null)
            return;
        Menu customerSpecificMenu = new Menu(inputReader, outputWriter, menuProvider.provideMenu((Librarian) loggedInUser));
        customerSpecificMenu.displayMenu();
        customerSpecificMenu.performSelectedAction();

    }

    @Override
    public String getMenuName() {
        return Constants.LIBRARIAN_LOGIN_MENU_NAME;
    }
}
