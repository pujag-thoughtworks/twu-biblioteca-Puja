package com.twu.biblioteca;

import com.twu.inputOutput.OutputWriter;

/**
 * Menu-Item to display customer profile.
 */
public class ViewProfileMenuItem implements MenuItem {
    Customer loggedInCustomer;
    OutputWriter outputWriter;

    public ViewProfileMenuItem(OutputWriter outputWriter, Customer customer) {
        this.outputWriter = outputWriter;
        loggedInCustomer = customer;
    }

    @Override
    public void performAction() {
        String[] profile = loggedInCustomer.getProfile();
        for (String profileElement : profile)
            outputWriter.write(profileElement);
    }

    @Override
    public String getMenuName() {
        return Constants.VIEW_PROFILE_MENU_NAME;
    }
}
