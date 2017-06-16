package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleInputReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * class to test ConsoleInputReader
 */
public class InputReaderTest {

    @Test
    public void shouldReadInput() {
        String str="Hello";
        ConsoleInputReader inputReader=new ConsoleInputReader(new BufferedReader(new
                StringReader(str)));
        String inputRead = inputReader.read();
        assertEquals(str, inputRead);

    }
}
