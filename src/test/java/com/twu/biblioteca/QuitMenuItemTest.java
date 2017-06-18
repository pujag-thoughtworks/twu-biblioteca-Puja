package com.twu.biblioteca;

import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for Quit menu
 */
public class QuitMenuItemTest {

    @Test
    public void shouldWriteQuitMessageWhenCalled() {
        TestOutputWriter testOutputWriter = new TestOutputWriter();
        QuitMenuItem quitMenuItem = new QuitMenuItem(testOutputWriter);

        quitMenuItem.performAction();

        assertEquals(QuitMenuItem.QUIT_MESSAGE, testOutputWriter.getOutput().get(0));
    }

}
