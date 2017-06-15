package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by pujag on 6/15/17.
 */
public class ConsoleWriterTest {

    @Test
    public void shouldWriteGivenInput() {
        StringWriter stringWriter=new StringWriter();
        ConsoleWriter consoleWriter=new ConsoleWriter(new BufferedWriter
                (stringWriter));

        consoleWriter.write("Hello world");

        assertEquals("Hello world\n",stringWriter.toString());

    }


}
