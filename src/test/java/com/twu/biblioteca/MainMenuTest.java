package com.twu.biblioteca;

import com.twu.mockModels.ExpectedOutput;
import com.twu.mockModels.TestMainMenu;
import com.twu.mockModels.TestOutputWriter;
import com.twu.mockModels.TestInputReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Test for menu items.
 */
public class MainMenuTest {

    @Test
    public void shouldBeAbleToAddMenuItemsToList() {

        TestOutputWriter testOutputWriter = new TestOutputWriter();
        TestInputReader testInputReader = new TestInputReader("");
        TestMainMenu mainMenu = new TestMainMenu(testInputReader, testOutputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(testOutputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        List<MenuItem> expectedMenu = new ArrayList<>();
        expectedMenu.add(listBooksMenuItem);

        List<MenuItem> actualMenu = mainMenu.getMenuItems();

        assertEquals(expectedMenu, actualMenu);
    }

    @Test
    public void shouldDisplayMenuOptions() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("");
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(MainMenu.DISPLAY_MESSAGE);
        expectedOutput.add("1) " + listBooksMenuItem.getMenuName());

        mainMenu.displayMenu();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1\n2");
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        QuitMenuItem quitMenuItem = new QuitMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        mainMenu.addMenuItems(quitMenuItem);
        ExpectedOutput preTestedOutput = new ExpectedOutput();
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.addAll(preTestedOutput.getOutputForListBooksMenuItems());
        expectedOutput.add(quitMenuItem.QUIT_MESSAGE);
        mainMenu.performSelectedAction();

        assertEquals(expectedOutput, outputWriter.getOutput());

    }

    @Test
    public void shouldAskForInputUnlessValidInputIsPassed() {

        TestInputReader inputReader = new TestInputReader("3\n4\n1\n2");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        QuitMenuItem quitMenuItem = new QuitMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        mainMenu.addMenuItems(quitMenuItem);
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(MainMenu.OPTION_INVALID_MESSAGE);
        expectedOutput.add(MainMenu.OPTION_INVALID_MESSAGE);
        expectedOutput.addAll(new ExpectedOutput().getOutputForListBooksMenuItems());
        expectedOutput.add(quitMenuItem.QUIT_MESSAGE);

        mainMenu.performSelectedAction();

        assertEquals(4, inputReader.getNoOfReads());
        assertEquals(expectedOutput, outputWriter.getOutput());

    }

    @Test
    public void userShouldBeAbleToSelectMenuOptionUnlessHeSelectsQuit() {

        TestInputReader inputReader = new TestInputReader("1\n1\n2");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        QuitMenuItem quitMenuItem = new QuitMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        mainMenu.addMenuItems(quitMenuItem);
        String[] addedMenuItemsNames = {listBooksMenuItem.getMenuName(), quitMenuItem.getMenuName()};
        List<String> expectedOutput = new ArrayList<>();
        ExpectedOutput preTestedOutput = new ExpectedOutput();
        expectedOutput.addAll(preTestedOutput.getOutputForListBooksMenuItems());
        expectedOutput.addAll(preTestedOutput.getOutputForListBooksMenuItems());
        expectedOutput.add(QuitMenuItem.QUIT_MESSAGE);

        mainMenu.performSelectedAction();

        assertEquals(expectedOutput, outputWriter.getOutput());

    }


}
