package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleOutputWriter;

/**
 * Interface for the various menus.
 */
public interface MenuItem {

    public void performAction();

    public String getMenuName();

}
