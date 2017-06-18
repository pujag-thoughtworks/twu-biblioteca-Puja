package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To test librarian
 */
public class LibrarianTest {

    @Test
    public void shouldKnowAboutTheAvailabilityOfABook() {
        Librarian librarian = new Librarian();
        BookStorage bookStorage = new BookStorage();
        Book requestedBook = bookStorage.getBookList().get(1);
        Book randomBook = new Book("xxx", "yyy", 1988);
        System.out.println(librarian.isBookAvailable(requestedBook.getName()));
        assertTrue(librarian.isBookAvailable(requestedBook.getName()));
        assertTrue(!librarian.isBookAvailable(randomBook.getName()));
    }

    @Test
    public void checkedOutBookShouldNotBeAvailable() {
        Librarian librarian = new Librarian();
        List<Book> availableBooks = librarian.getAvailableBooks();
        Book requestedBook = availableBooks.get(0);

        librarian.checkoutBook(requestedBook.getName());

        assertTrue(!availableBooks.contains(requestedBook));

    }
}
