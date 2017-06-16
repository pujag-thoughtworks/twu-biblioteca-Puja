package com.twu.biblioteca;

import com.twu.mockModels.TestConsoleWriter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Test for menu items.
 */
public class MainMenuTest {

    @Test
    public void shouldDisplayMenuOptions() {

        MainMenu mainMenu=new MainMenu();
        mainMenu.addMenuItems(new ListAvailableBooks());
        ArrayList<String> expectedOutput= new ArrayList<>();
        expectedOutput.add(MainMenu.DISPLAY_MESSAGE);
        expectedOutput.add("1) ListAvailableBooks");
        TestConsoleWriter consoleWriter=new TestConsoleWriter(null);

        mainMenu.displayMenu(consoleWriter);

        assertEquals(expectedOutput,consoleWriter.getOutput());
    }

    @Test
    public void shouldLoadAMenuItemBasedOnSelection() {

    }


}
