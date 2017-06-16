package com.twu.biblioteca;

import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

import java.util.*;

/**
 * Menu that appears on start up.
 */
public class MainMenu {

    Map<Integer, MenuItem> menuMapper;
    OutputWriter outputWriter;
    InputReader inputReader;

    public static final String DISPLAY_MESSAGE = "MENU:\n For Selecting any " +
            "option enter the menuIndex corresponding to it\n";

    MainMenu(InputReader inputReader,OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
        this.inputReader=inputReader;
        menuMapper = new HashMap<>();

    }

    public void addMenuItems(MenuItem menuItem) {
        int index = menuMapper.size();
        menuMapper.put(index + 1, menuItem);
    }

    public void display() {
        outputWriter.write(DISPLAY_MESSAGE);
        for (int keyIndex : menuMapper.keySet()) {
            String option = keyIndex + ") " + menuMapper.get(keyIndex)
                    .getMenuName();
            outputWriter.write(option);
        }
    }

    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuList = new ArrayList<>(menuMapper.values());
        return menuList;
    }


    public void loadSelectedMenu() {
        int menuOptionNo = Integer.parseInt(inputReader.read());
        MenuItem selectedMenu = menuMapper.get(menuOptionNo);
        selectedMenu.showContent();
    }
}
