package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To test librarian
 */
public class LibrarianTest {

    @Test
    public void checkedOutBookShouldNotBeAvailable() {
        Librarian librarian = new Librarian();
        List<Book> availableBooks = librarian.getAvailableBooks();
        Book requestedBook = availableBooks.get(0);

        librarian.checkoutBook(requestedBook.getName());

        assertTrue(!availableBooks.contains(requestedBook));
    }

    @Test
    public void shouldKnowIfABookIsAvailableForCheckout() {
        Librarian librarian = new Librarian();
        List<Book> availableBooks = librarian.getAvailableBooks();
        Book requestedBook = availableBooks.get(0);
        librarian.checkoutBook(requestedBook.getName());

        boolean output=librarian.isBookAvailableForCheckout(requestedBook.getName());

        assertEquals(false,output);
    }

    @Test
    public void returnedBookShouldBeAvailableForCheckoutAgain() {
        Librarian librarian = new Librarian();
        List<Book> availableBooks = librarian.getAvailableBooks();
        Book requestedBook = availableBooks.get(0);

        librarian.checkoutBook(requestedBook.getName());
        librarian.returnBook(requestedBook.getName());

        assertTrue(availableBooks.contains(requestedBook));
    }
    @Test
    public void shouldKnowIfABookBelongsToLibrary() {
        Librarian librarian = new Librarian();
        Book randomBook = new Book("xxx", "yyy", 1988);
        assertFalse(librarian.doesBookBelongsToLibrary(randomBook.getName()));
    }

}
