package com.twu.biblioteca;

import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To test librarian
 */
public class LibrarianTest {

    @Test
    public void checkedOutBookShouldNotBeDisplayed() {
        TestOutputWriter outputWriter=new TestOutputWriter();
        Librarian librarian=new Librarian();
        Book book=new Book("Harry Potter","J.K Rowling",2000);

        librarian.checkoutBook("Harry Potter");
        List<Book> availableBooks=librarian.getAvailableBooks();

        assertTrue(!availableBooks.contains(book));

    }
}
