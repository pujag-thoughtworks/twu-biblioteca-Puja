package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for ReturnBookMenuItem
 */
public class ReturnBookMenuItemTest {
    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulReturn() {

        Librarian librarian = new Librarian();
        Book requestedBook = librarian.getAvailableBooks().get(0);
        String bookName = requestedBook.getName();

        TestInputReader inputReader = new TestInputReader(bookName + "\n" + bookName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        librarian.checkoutBook(bookName);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(inputReader, outputWriter, librarian);

        returnBookMenuItem.performAction();

        assertEquals(ReturnBookMenuItem.SUCCESSFUL_RETURN_MESSAGE, outputWriter.getOutput().get(1));
    }

    @Test
    public void shouldDisplayFailureMessageOnUnSuccessfulReturn() {

        Librarian librarian = new Librarian();
        Book randomBook = new Book("hh", "kk", 2004);
        TestInputReader inputReader = new TestInputReader("hh");
        TestOutputWriter outputWriter = new TestOutputWriter();
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(inputReader, outputWriter, librarian);

        returnBookMenuItem.performAction();

        assertEquals(ReturnBookMenuItem.UNSUCCESSFUL_RETURN_MESSAGE, outputWriter.getOutput().get(1));
    }
}
