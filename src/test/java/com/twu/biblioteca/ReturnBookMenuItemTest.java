package com.twu.biblioteca;

import com.twu.buildingBlocks.Book;
import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import com.twu.resources.BookStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for ReturnBookMenuItem
 */
public class ReturnBookMenuItemTest {
    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulReturn() {

        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        Book requestedBook = inventory.getAvailableItems().get(0);
        String bookName = requestedBook.getName();

        TestInputReader inputReader = new TestInputReader(bookName + "\n" + bookName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        inventory.checkoutItem(bookName, new UserDirectory().getCustomer("CUS-0001"));
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(inputReader, outputWriter, inventory, null);

        returnBookMenuItem.performAction();

        assertEquals(ReturnBookMenuItem.SUCCESSFUL_RETURN_MESSAGE, outputWriter.getOutput().get(1));
    }

    @Test
    public void shouldDisplayFailureMessageOnUnsuccessfulReturn() {

        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        TestInputReader inputReader = new TestInputReader("The ultimate gift");
        TestOutputWriter outputWriter = new TestOutputWriter();
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(inputReader, outputWriter, inventory, null);

        returnBookMenuItem.performAction();

        assertEquals(ReturnBookMenuItem.UNSUCCESSFUL_RETURN_MESSAGE, outputWriter.getOutput().get(1));
    }

}
