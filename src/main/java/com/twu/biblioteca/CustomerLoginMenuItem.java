package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Customer login page.
 */
public class CustomerLoginMenuItem<T extends User> implements MenuItem {

    static final String CUSTOMER_LOGIN_MENU_NAME = "Customer Login Menu";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private MenuProvider menuProvider;
    private UserAuthentication userAuthentication;

    CustomerLoginMenuItem(InputReader inputReader, OutputWriter outputWriter, MenuProvider menuProvider) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.menuProvider = menuProvider;
        this.userAuthentication=new UserAuthentication(inputReader,outputWriter);
    }

    @Override
    public void performAction() {

        User loggedInUser = userAuthentication.authenticateUser(Customer.USER_TYPE);
        if (loggedInUser == null)
            return;
        Menu customerSpecificMenu = new Menu(inputReader, outputWriter, menuProvider.provideMenu((Customer)loggedInUser));
        customerSpecificMenu.displayMenu();
        customerSpecificMenu.performSelectedAction();
    }

    @Override
    public String getMenuName() {
        return CUSTOMER_LOGIN_MENU_NAME;
    }
}
