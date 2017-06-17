package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

import java.util.*;

/**
 * Menu that appears on start up.
 * It lists the available options and users have to input their respective choice
 */

public class MainMenu {

    public static final String DISPLAY_MESSAGE = "MENU:\n";
    public static final String MESSAGE_TO_REQUEST_INPUT = "\nPlease enter your choice: ";

    private OutputWriter outputWriter;
    private InputReader inputReader;
    ListBooksMenuItem listBooksMenuItem;
    QuitMenuItem quitMenuItem;

    private Map<Integer, MenuItem> menuMapper;

    public MainMenu(InputReader inputReader, OutputWriter outputWriter, ListBooksMenuItem listBooksMenuItem) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.listBooksMenuItem = listBooksMenuItem;
        quitMenuItem = new QuitMenuItem(outputWriter);
        menuMapper = new HashMap<>();
        menuMapper.put(1, listBooksMenuItem);
        menuMapper.put(2, quitMenuItem);

    }

    public void displayMenu() {
        outputWriter.write(DISPLAY_MESSAGE);
        for (Map.Entry<Integer, MenuItem> mapEntry : menuMapper.entrySet()) {
            String option = mapEntry.getKey() + ") " + mapEntry.getValue().getMenuName();
            outputWriter.write(option);
        }
        outputWriter.write(MESSAGE_TO_REQUEST_INPUT);
    }

    public void performSelectedAction() {
        MenuItem selectedMenu;
        String menuName;

        do {
            int userInput = readUserInput();
            selectedMenu = menuMapper.getOrDefault(userInput, new InvalidMenuItem(outputWriter));
            menuName = selectedMenu.getMenuName();
            selectedMenu.performAction();
            if (menuName != null && !menuName.equals(QuitMenuItem.MENU_NAME))
                displayMenu();
        } while (menuName == null || !menuName.equals(QuitMenuItem.MENU_NAME));

    }

    private int readUserInput() {
        int userInput;
        try {
            userInput = Integer.parseInt(inputReader.read());
        } catch (NumberFormatException e) {
            return 0;
        }
        return userInput;
    }

}
