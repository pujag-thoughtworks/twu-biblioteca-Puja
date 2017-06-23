package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Tests Librarian login menu item
 */
public class LibrarianLoginMenuItemTest {
    @Test
    public void shouldPerformSelectedActionFromLibrarianSpecificMenu() {

        TestInputReader testInputReader=new TestInputReader("LIB-0001\npassword\n3");
        TestOutputWriter testOutputWriter=new TestOutputWriter();
        LibrarianLoginMenuItem librarianLoginMenu=new LibrarianLoginMenuItem(testInputReader,testOutputWriter,
                new MenuProvider(testInputReader,testOutputWriter));

        librarianLoginMenu.performAction();
        List<String> displayOutput=testOutputWriter.getOutput();

        assertTrue(displayOutput.contains(LogOutMenuItem.LOG_OUT_MESSAGE));
    }
}
