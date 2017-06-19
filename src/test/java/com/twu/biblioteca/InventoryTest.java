package com.twu.biblioteca;

import com.twu.resources.BookStorage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To test librarian
 */
public class InventoryTest {

    @Test
    public void checkedOutBookShouldNotBeAvailable() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);

        inventory.checkoutItem(requestedBook.getName());

        assertTrue(!availableBooks.contains(requestedBook));
    }

    @Test
    public void shouldKnowIfABookIsAvailableForCheckout() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);
        inventory.checkoutItem(requestedBook.getName());

        boolean output = inventory.isItemAvailableForCheckout(requestedBook.getName());

        assertEquals(false, output);
    }

    @Test
    public void returnedBookShouldBeAvailableForCheckoutAgain() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);

        inventory.checkoutItem(requestedBook.getName());
        inventory.returnItem(requestedBook.getName());

        assertTrue(availableBooks.contains(requestedBook));
    }

    @Test
    public void shouldKnowIfABookBelongsToLibrary() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        Book randomBook = new Book("xxx", "yyy", 1988);
        assertFalse(inventory.doesItemBelongsToLibrary(randomBook.getName()));
    }

}
