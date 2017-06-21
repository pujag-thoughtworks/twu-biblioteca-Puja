package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Customer login page.
 */
public class CustomerLoginMenuItem implements MenuItem {

    static final String CUSTOMER_LOGIN_MENU_NAME = "Customer Login Menu";
    static final String LIBRARY_No_REQUEST = "Please enter your library number:";
    static final String PASSWORD_REQUEST = "Please enter your password:";
    static final String INVALID_USERNAME = "Username invalid!";
    static final String INCORRECT_PASSWORD = "Entered password is incorrect!";
    static final String SUCCESSFUL_LOGIN_MESSAGE = "Successfully,logged in";

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private UserDirectory userDirectory;
    private MenuProvider menuProvider;

    CustomerLoginMenuItem(InputReader inputReader, OutputWriter outputWriter, MenuProvider menuProvider) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.menuProvider = menuProvider;
        userDirectory = new UserDirectory();

    }

     Customer authenticateCustomer() {

        outputWriter.write(LIBRARY_No_REQUEST);
        String libraryNo = inputReader.read();
        Customer customer = userDirectory.getCustomer(libraryNo);
        if (customer == null) {
            outputWriter.write(INVALID_USERNAME);
            return null;
        }
        outputWriter.write(PASSWORD_REQUEST);
        String providedPwd = inputReader.read();
        if (!providedPwd.equals(customer.getPassword())) {
            outputWriter.write(INCORRECT_PASSWORD);
            return null;
        }
        outputWriter.write(SUCCESSFUL_LOGIN_MESSAGE);
        return customer;

    }


    @Override
    public void performAction() {
        Customer loggedInCustomer = authenticateCustomer();
        if (loggedInCustomer == null)
            return;
        Menu customerSpecificMenu = new Menu(inputReader, outputWriter, menuProvider.provideMenu(loggedInCustomer));
        customerSpecificMenu.displayMenu();
        customerSpecificMenu.performSelectedAction();
    }

    @Override
    public String getMenuName() {
        return CUSTOMER_LOGIN_MENU_NAME;
    }
}
