package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

/**
 * Created by pujag on 6/20/17.
 */
public class CustomerLoginMenuItem implements MenuItem {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Inventory inventory;
    private UserDirectory userDirectory;

    CustomerLoginMenuItem(InputReader inputReader, OutputWriter outputWriter,Inventory inventory) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inventory = inventory;
        userDirectory=new UserDirectory();

    }


    @Override
    public void performAction() {
        outputWriter.write()

    }

    @Override
    public String getMenuName() {
        return Constants.CLIENT_LOGIN_MENU_NAME;
    }
}
