package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * this classes tests whether the different methods are called in sequence.
 */
public class LibrarySystemTest {

    @Test
    public void shouldWriteWelcomeMessage() {

        TestOutputWriter outputWriter = new TestOutputWriter();
        TestInputReader inputReader = new TestInputReader("1\n5");
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);
        List<String> output = outputWriter.getOutput();

        librarySystem.start();

        assertEquals(librarySystem.WELCOME_MESSAGE, output.get(0));
    }

    @Test
    public void sequenceOfOutputShouldBeValid() {

        TestInputReader inputReader = new TestInputReader("1\n5");
        TestOutputWriter outputWriter = new TestOutputWriter();
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);

        TestInputReader testInputReader=new TestInputReader("1\n5");
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        MenuProvider menuProvider=new MenuProvider(testInputReader,testOutputWriter);
        Menu menu = new Menu(testInputReader, testOutputWriter,menuProvider.provideMenu());
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(LibrarySystem.WELCOME_MESSAGE);

        librarySystem.start();
        menu.displayMenu();
        menu.performSelectedAction();

        expectedOutput.addAll(testOutputWriter.getOutput());
        assertEquals(expectedOutput, outputWriter.getOutput());

    }

}
