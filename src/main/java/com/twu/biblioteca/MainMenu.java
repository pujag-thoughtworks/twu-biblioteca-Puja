package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

import java.util.*;

/**
 * Menu that appears on start up.
 * It lists the available options and users have to input their respective choice
 */
public class MainMenu {

    private Map<String, MenuItem> menuMapper;
    OutputWriter outputWriter;
    InputReader inputReader;

    public static final String DISPLAY_MESSAGE = "MENU:\nFor selecting any " +
            "option enter the menuIndex corresponding to it\n";
    public static final String OPTION_INVALID_MESSAGE="Select a valid option!";

    public MainMenu(InputReader inputReader, OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        menuMapper = new HashMap<>();

    }

    public void addMenuItems(MenuItem menuItem) {
        int index = menuMapper.size();
        menuMapper.put(index + 1 +"", menuItem);
    }

    public void display() {
        outputWriter.write(DISPLAY_MESSAGE);
        for (String keyIndex : menuMapper.keySet()) {
            String option = keyIndex + ") " + menuMapper.get(keyIndex)
                    .getMenuName();
            outputWriter.write(option);
        }
    }


    public void performSelectedAction() {
        MenuItem selectedMenu;
        do {
            String userInput = inputReader.read();
            selectedMenu = menuMapper.getOrDefault(userInput, new InvalidMenuOption());
            if (selectedMenu.getMenuName() == null)
                outputWriter.write(OPTION_INVALID_MESSAGE);
        } while (selectedMenu.getMenuName()==null);
        selectedMenu.performAction();
    }

}
