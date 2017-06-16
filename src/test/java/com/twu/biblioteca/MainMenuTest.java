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

        TestOutputWriter testOutputWriter=new TestOutputWriter();
        TestInputReader testInputReader=new TestInputReader("");
        MainMenu mainMenu=new MainMenu(testInputReader,testOutputWriter);
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(testOutputWriter);
        mainMenu.addMenuItems(listAvailableBooks);
        List<MenuItem> expectedMenu=new ArrayList<>();
        expectedMenu.add(listAvailableBooks);

        List<MenuItem> actualMenu=mainMenu.getMenuItems();

        assertEquals(expectedMenu,actualMenu);
    }

    @Test
    public void shouldDisplayMenuOptions() {
        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader=new TestInputReader("");
        MainMenu mainMenu=new MainMenu(inputReader,outputWriter);
        mainMenu.addMenuItems(new ListAvailableBooks(outputWriter));
        ArrayList<String> expectedOutput= new ArrayList<>();
        expectedOutput.add(MainMenu.DISPLAY_MESSAGE);
        expectedOutput.add("1) ListAvailableBooks");

        mainMenu.display();

        assertEquals(expectedOutput,outputWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader=new TestInputReader("1");
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        MainMenu mainMenu=new MainMenu(inputReader,outputWriter);
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(outputWriter);
        mainMenu.addMenuItems(listAvailableBooks);
        ListAvailableBooks expectedListAvailableBook=new ListAvailableBooks(testOutputWriter);

        expectedListAvailableBook.showContent();
        mainMenu.loadSelectedMenu();

        assertEquals(testOutputWriter.getOutput(),outputWriter.getOutput());

    }


}
