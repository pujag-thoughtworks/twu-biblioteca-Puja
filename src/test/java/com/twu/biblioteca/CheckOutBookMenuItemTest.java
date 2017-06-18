package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * tests features of checkOutBookMenuItem
 */
public class CheckOutBookMenuItemTest {

    @Test
    public void shouldDisplayCheckOutStatus() {

        Librarian librarian = new Librarian();
        Book requestedBook = librarian.getAvailableBooks().get(0);
        String bookName = requestedBook.getName();
        TestInputReader inputReader = new TestInputReader(bookName + "\n" + bookName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        CheckOutBookMenuItem checkOutBookMenuItem = new CheckOutBookMenuItem(inputReader, outputWriter, librarian);

        checkOutBookMenuItem.performAction();
        checkOutBookMenuItem.performAction();

        assertEquals(CheckOutBookMenuItem.SUCCESSFUL_CHECKOUT_MESSAGE, outputWriter.getOutput().get(1));
        assertEquals(CheckOutBookMenuItem.UNSUCCESSFUL_CHECKOUT_MESSAGE, outputWriter.getOutput().get(3));
    }

}
