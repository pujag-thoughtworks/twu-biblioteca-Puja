package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleOutputWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by pujag on 6/15/17.
 */
public class ConsoleOutputWriterTest {

    @Test
    public void shouldWriteGivenInput() {
        StringWriter stringWriter = new StringWriter();
        ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter(new BufferedWriter
                (stringWriter));

        consoleOutputWriter.write("Hello world");

        assertEquals("Hello world\n", stringWriter.toString());

    }


}
