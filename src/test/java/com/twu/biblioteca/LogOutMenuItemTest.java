package com.twu.biblioteca;

import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests log-out menu item.
 */
public class LogOutMenuItemTest {

    @Test
    public void shouldDisplayLogOutMessage() {
        TestOutputWriter outputWriter=new TestOutputWriter();
        LogOutMenuItem logOutMenuItem=new LogOutMenuItem(outputWriter);

        logOutMenuItem.performAction();

        assertEquals(LogOutMenuItem.LOG_OUT_MESSAGE,outputWriter.getOutput().get(0));
    }
}
