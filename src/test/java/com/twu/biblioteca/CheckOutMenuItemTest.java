package com.twu.biblioteca;

import com.twu.buildingBlocks.Book;
import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import com.twu.resources.BookStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * tests features of checkOutBookMenuItem
 */
public class CheckOutMenuItemTest {

    @Test
    public void shouldDisplayCheckOutStatus() {

        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        Book requestedBook = inventory.getAvailableItems().get(0);
        String bookName = requestedBook.getName();

        TestInputReader inputReader = new TestInputReader(bookName + "\n" + bookName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        CheckOutMenuItem<Book> checkOutMenuItem = new CheckOutMenuItem<>(inputReader, outputWriter, inventory, null);

        checkOutMenuItem.performAction();
        checkOutMenuItem.performAction();

        assertEquals(CheckOutMenuItem.SUCCESSFUL_CHECKOUT_MESSAGE, outputWriter.getOutput().get(1));
        assertEquals(CheckOutMenuItem.UNSUCCESSFUL_CHECKOUT_MESSAGE, outputWriter.getOutput().get(3));
    }







}
