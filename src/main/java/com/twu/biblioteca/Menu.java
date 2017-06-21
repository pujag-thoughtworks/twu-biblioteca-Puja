package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;
import com.twu.resources.BookStorage;
import com.twu.resources.MovieStorage;

import java.util.*;

/**
 * Class representing menu.
 * It lists the available options and users have to input their respective choice
 */

public class Menu {

    public static final String DISPLAY_MESSAGE = "\nMENU:";
    public static final String MESSAGE_TO_REQUEST_INPUT = "\nPlease enter your choice: ";

    private OutputWriter outputWriter;
    private InputReader inputReader;
    private List<MenuItem> menuList;

    Menu(InputReader inputReader, OutputWriter outputWriter, List<MenuItem> menuList) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.menuList = menuList;
        menuList.add(0, new InvalidMenuItem(outputWriter));
    }

    void displayMenu() {
        outputWriter.write(DISPLAY_MESSAGE);
        for (int menuIndex = 1; menuIndex < menuList.size(); menuIndex++) {
            MenuItem menuItem = menuList.get(menuIndex);
            String option = menuIndex + ") " + menuItem.getMenuName();
            outputWriter.write(option);

        }
        outputWriter.write(MESSAGE_TO_REQUEST_INPUT);
    }

    void performSelectedAction() {
        MenuItem selectedMenu;
        String menuName;
        do {
            int userInput = readUserInput();
            selectedMenu = menuList.get(userInput);
            menuName = selectedMenu.getMenuName();
            selectedMenu.performAction();
            if (menuName != null && !menuName.equals(QuitMenuItem.MENU_NAME))
                displayMenu();
        }
        while (menuName == null || (!menuName.equals(Constants.LOG_OUT_MENU_NAME) && !menuName.equals(QuitMenuItem.MENU_NAME)));
    }

    private int readUserInput() {
        int userInput;
        try {
            userInput = Integer.parseInt(inputReader.read());
            if (userInput >= menuList.size())
                userInput = 0;
        } catch (NumberFormatException e) {
            return 0;
        }
        return userInput;
    }

}
