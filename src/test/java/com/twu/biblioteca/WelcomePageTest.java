package com.twu.biblioteca;

import com.twu.inputOutput.ConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * Test the welcome page
 */
public class WelcomePageTest {

    @Test
    public  void ShouldGetExpectedWelcomeMessage() {
        WelcomePage welcomePage=new WelcomePage("Hello");
        assertEquals("Hello",welcomePage.getWelcomeMessage());
    }

    @Test
    public void shouldWriteWelcomeMessageToDesiredOutputStream() {
        WelcomePage welcomePage=new WelcomePage("Hello");
        StringWriter stringWriter=new StringWriter();
        BufferedWriter bufferedWriter=new BufferedWriter(stringWriter);

        welcomePage.writeWelcomeMessage(new ConsoleWriter
                (bufferedWriter));

        assertEquals("Hello",stringWriter);
    }




}
