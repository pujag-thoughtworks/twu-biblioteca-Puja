package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by pujag on 6/15/17.
 */
public class LibrarySystemTest {

    @Test
    public void shouldWriteWelcomeMessage() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1");
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);
        List<String> output = outputWriter.getOutput();

        librarySystem.start();
        assertEquals(librarySystem.WELCOME_MESSAGE, output.get(0));
    }

    // TODO: Rename second test case with each feature addition

    @Test
    public void shouldDisplayMenuAfterGreetingUser() {
        TestInputReader inputReaderToGenerateExpectedOutput = new TestInputReader("1");
        TestOutputWriter outputWriterToGenerateExpectedOutput = new TestOutputWriter();
        MainMenu mainMenuToGenerateExpectedOutput = new MainMenu(inputReaderToGenerateExpectedOutput,
                outputWriterToGenerateExpectedOutput);
        mainMenuToGenerateExpectedOutput.addMenuItems(new ListBooksMenuItem(outputWriterToGenerateExpectedOutput));
        mainMenuToGenerateExpectedOutput.display();
        mainMenuToGenerateExpectedOutput.performSelectedAction();
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(LibrarySystem.WELCOME_MESSAGE);
        expectedOutput.addAll(outputWriterToGenerateExpectedOutput.getOutput());

        TestInputReader inputReader = new TestInputReader("1");
        TestOutputWriter outputWriter = new TestOutputWriter();
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);

        librarySystem.start();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

}
