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
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ExpectedOutput expectedOutput=new ExpectedOutput();

        mainMenu.displayMenu();

        assertEquals(expectedOutput.getMenuDisplayOutput(), outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("4");
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);

        mainMenu.performSelectedAction();

        assertEquals(QuitMenuItem.QUIT_MESSAGE,outputWriter.getOutput().get(0));
    }

    @Test
    public void shouldAskForInputUnlessValidInputIsPassed() {

        TestInputReader inputReader = new TestInputReader("8\na\n4");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);

        List<String> expectedOutput=new ArrayList<>();
        expectedOutput.add(InvalidMenuItem.OPTION_INVALID_MESSAGE);
        expectedOutput.add(InvalidMenuItem.OPTION_INVALID_MESSAGE);
        expectedOutput.add(QuitMenuItem.QUIT_MESSAGE);

        mainMenu.performSelectedAction();

        assertEquals(expectedOutput,outputWriter.getOutput());
    }

    @Test
    public void userShouldBeAbleToSelectMenuOptionUnlessHeSelectsQuit() {

        TestInputReader inputReader = new TestInputReader("1\n4");
        TestOutputWriter outputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);

        ExpectedOutput preTestedOutput=new ExpectedOutput();
        List<String> requiredOutput=new ArrayList<>(preTestedOutput.getListBooksOutput());
        requiredOutput.addAll(preTestedOutput.getMenuDisplayOutput());
        requiredOutput.add(QuitMenuItem.QUIT_MESSAGE);

        mainMenu.performSelectedAction();

        assertEquals(requiredOutput,outputWriter.getOutput());

    }


}
