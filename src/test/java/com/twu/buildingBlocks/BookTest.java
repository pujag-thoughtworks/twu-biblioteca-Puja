package com.twu.buildingBlocks;

import com.twu.buildingBlocks.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class For Book
 */
public class BookTest {

    @Test
    public void shouldGetName() {
        Book book = new Book("Harry Potter", "J.K Rowling", 2000);
        String bookName = book.getName();
        assertEquals("Harry Potter", bookName);
    }

    @Test
    public void stringRepresentationShouldBeWellFormatted() {
        Book book = new Book("Harry Potter", "J.K Rowling", 2000);
        String expectedOutput = String.format("%-30s%-30s%-15s", "Harry Potter", "J.K Rowling", 2000);
        assertEquals(expectedOutput, book.toString());
    }

    @Test
    public void booksWithSameDetailsShouldBeSame() {
        Book book1 = new Book("2 States", "Chetan Bhagat", 2005);
        Book book2 = new Book("2 States", "Chetan Bhagat", 2005);
        assertEquals(book1, book2);
    }

}
