package com.twu.biblioteca;

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
        mainMenu.addMenuItems(new ListBooksMenuItem(outputWriter));
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(MainMenu.DISPLAY_MESSAGE);
        expectedOutput.add("1) List Available Books");

        mainMenu.display();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {
        TestOutputWriter testOutputWriterForExpectedOutput = new TestOutputWriter();
        ListBooksMenuItem expectedListAvailableBook = new ListBooksMenuItem(testOutputWriterForExpectedOutput);
        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1");
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);

        expectedListAvailableBook.performAction();
        mainMenu.performSelectedAction();

        assertEquals(testOutputWriterForExpectedOutput.getOutput(), outputWriter.getOutput());

    }

    @Test
    public void shouldAskForInputUnlessValidInputIsPassed() {

        TestInputReader inputReader=new TestInputReader("3\n2\n1");
        TestOutputWriter outputWriter = new TestOutputWriter();
        TestOutputWriter outputWriterForTest=new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        ListBooksMenuItem listBooksMenuItemForTest=new ListBooksMenuItem(outputWriterForTest);
        mainMenu.addMenuItems(listBooksMenuItem);
        List<String> expectedOutput=new ArrayList<>();
        expectedOutput.add(MainMenu.OPTION_INVALID_MESSAGE);
        expectedOutput.add(MainMenu.OPTION_INVALID_MESSAGE);
        listBooksMenuItemForTest.performAction();
        expectedOutput.addAll(outputWriterForTest.getOutput());

        mainMenu.performSelectedAction();

        assertEquals(3,inputReader.getNoOfReads());
        assertEquals(expectedOutput,outputWriter.getOutput());

    }


}
