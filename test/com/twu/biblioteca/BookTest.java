package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pujag on 6/14/17.
 */
public class BookTest {

    @Test
    public void shouldTellItsNameWhenAsked() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        String bookName=book.getName();
        assertEquals("Harry Potter",bookName);
    }

    @Test
    public void shouldTellItsAuthorNameWhenAsked() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        String authorName=book.getAuthor();
        assertEquals("J.K Rowling",authorName);
    }

    @Test
    public void shouldTellItsYearOfPublishWhenAsked() {
        Book book=new Book("Harry Potter", "J.K Rowling", 2000);
        int yearOfPublication=book.getPublishingYear();
        assertEquals(2000,yearOfPublication);
    }

}
