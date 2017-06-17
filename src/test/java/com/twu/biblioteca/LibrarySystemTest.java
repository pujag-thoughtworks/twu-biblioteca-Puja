package com.twu.biblioteca;

import com.twu.mockModels.ExpectedOutput;
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
        TestInputReader inputReader = new TestInputReader("1");
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);
        List<String> output = outputWriter.getOutput();

        librarySystem.start();
        assertEquals(librarySystem.WELCOME_MESSAGE, output.get(0));
    }

    @Test
    public void sequenceOfOutputShouldBeValid() {

        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(LibrarySystem.WELCOME_MESSAGE);
        TestInputReader inputReader = new TestInputReader("1");
        TestOutputWriter outputWriter = new TestOutputWriter();
        LibrarySystem librarySystem = new LibrarySystem(inputReader, outputWriter);
        ExpectedOutput preKnownOutput = new ExpectedOutput();
        expectedOutput.addAll(preKnownOutput.getOutputForMainMenuDispaly());
        expectedOutput.addAll(preKnownOutput.getOutputForLisBooksMenuItems());

        librarySystem.start();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

}
