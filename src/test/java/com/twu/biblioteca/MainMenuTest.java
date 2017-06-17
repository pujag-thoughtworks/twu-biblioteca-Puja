package com.twu.biblioteca;

import com.twu.mockModels.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Test for menu items.
 */
public class MainMenuTest {

    @Test
    public void shouldDisplayMenuOptions() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("");
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter, listBooksMenuItem);

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(MainMenu.DISPLAY_MESSAGE);
        expectedOutput.add("1) " + listBooksMenuItem.getMenuName());
        expectedOutput.add("2) " + QuitMenuItem.MENU_NAME);
        expectedOutput.add(MainMenu.MESSAGE_TO_REQUEST_INPUT);

        mainMenu.displayMenu();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1\n2");
        TestListBooksMenuItem listBooksMenuItem = new TestListBooksMenuItem(outputWriter);
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter, listBooksMenuItem);

        mainMenu.performSelectedAction();

        assertEquals(1, listBooksMenuItem.getCountOfPerformActionCalls());
    }

    @Test
    public void shouldAskForInputUnlessValidInputIsPassed() {

        TestInputReader inputReader = new TestInputReader("3\n4\n1\n2");
        TestOutputWriter outputWriter = new TestOutputWriter();
        TestListBooksMenuItem listBooksMenuItem = new TestListBooksMenuItem(outputWriter);
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter, listBooksMenuItem);

        mainMenu.performSelectedAction();

        assertEquals(4, inputReader.getNoOfReads());
        assertEquals(InvalidMenuItem.OPTION_INVALID_MESSAGE, outputWriter.getOutput().get(0));
    }

    @Test
    public void userShouldBeAbleToSelectMenuOptionUnlessHeSelectsQuit() {

        TestInputReader inputReader = new TestInputReader("1\n1\n2");
        TestOutputWriter outputWriter = new TestOutputWriter();
        TestListBooksMenuItem listBooksMenuItem = new TestListBooksMenuItem(outputWriter);
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter, listBooksMenuItem);

        mainMenu.performSelectedAction();

        assertEquals(2, listBooksMenuItem.getCountOfPerformActionCalls());

    }


}
