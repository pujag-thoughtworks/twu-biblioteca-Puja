package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

import java.util.*;

/**
 * Menu that appears on start up.
 * It lists the available options and users have to input their respective choice
 */

public class MainMenu {

    public static final String DISPLAY_MESSAGE = "\nMENU:";
    public static final String MESSAGE_TO_REQUEST_INPUT = "\nPlease enter your choice: ";

    private OutputWriter outputWriter;
    private InputReader inputReader;


    private Map<Integer, MenuItem> menuMapper;

    MainMenu(InputReader inputReader, OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        initializeFields(inputReader, outputWriter);

    }

    private void initializeFields(InputReader inputReader, OutputWriter outputWriter) {
        Librarian librarian = new Librarian();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter, librarian);
        CheckOutBookMenuItem checkOutBookMenuItem = new CheckOutBookMenuItem(inputReader, outputWriter, librarian);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(inputReader, outputWriter, librarian);
        QuitMenuItem quitMenuItem = new QuitMenuItem(outputWriter);

        menuMapper = new HashMap<>();
        menuMapper.put(1, listBooksMenuItem);
        menuMapper.put(2, checkOutBookMenuItem);
        menuMapper.put(3, returnBookMenuItem);
        menuMapper.put(4, quitMenuItem);

    }

    void displayMenu() {
        outputWriter.write(DISPLAY_MESSAGE);
        for (Map.Entry<Integer, MenuItem> mapEntry : menuMapper.entrySet()) {
            String option = mapEntry.getKey() + ") " + mapEntry.getValue().getMenuName();
            outputWriter.write(option);
        }
        outputWriter.write(MESSAGE_TO_REQUEST_INPUT);
    }

    void performSelectedAction() {
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
