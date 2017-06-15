package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class For Book
 */
public class BookTest {

    @Test
    public void shouldGetName() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        String bookName=book.getName();
        assertEquals("Harry Potter",bookName);
    }

    @Test
    public void shouldGetAuthorName() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        String authorName=book.getAuthor();
        assertEquals("J.K Rowling",authorName);
    }

    @Test
    public void shouldGetPublishingYear() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        int yearOfPublication=book.getPublishingYear();
        assertEquals(2000,yearOfPublication);
    }

    @Test
    public void shouldBeRepresentedAsString() {
        Book book=new Book("Harry Potter","J.K Rowling",2000);
        String expectedOutput="Harry Potter" + " " + "J.K Rowling" + " " +2000;
        assertEquals(expectedOutput,book.toString());
    }

}
