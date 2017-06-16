package com.twu.biblioteca;

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
        MainMenu mainMenu = new MainMenu(testInputReader, testOutputWriter);
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

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1");
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        MainMenu mainMenu = new MainMenu(inputReader, outputWriter);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter);
        mainMenu.addMenuItems(listBooksMenuItem);
        ListBooksMenuItem expectedListAvailableBook = new ListBooksMenuItem(testOutputWriter);

        expectedListAvailableBook.performAction();
        mainMenu.performSelectedAction();

        assertEquals(testOutputWriter.getOutput(), outputWriter.getOutput());

    }


}
