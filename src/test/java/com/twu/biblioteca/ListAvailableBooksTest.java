package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * List Books - As a customer, after the welcome message appears I would like to see a list of all library books, so that I can browse for books I might want to check-out. Assume that there is a pre-existing list of books. You don't need to support adding or removing books from the library.
 * The book listing should have columns for book information information.
 */
public class ListAvailableBooksTest {

    @Test
    public void shouldListAGivenListOfBooks() {

        ArrayList<Book> bookList=new ArrayList<>();
        Book book1=new Book("Harry Potter","JK Rowling", 2000);
        Book book2=new Book("A Walk To Remember","Nicholas Spark",1999);
        bookList.add(book1);
        bookList.add(book2);
        ListAvailableBooks listBooks=new ListAvailableBooks(bookList);
        String[] expectedOutput={book1.toString(),book2.toString()};
        String[] actualOutput=listBooks.list();
        System.out.println(actualOutput);

        assertTrue(Arrays.equals(expectedOutput,actualOutput));

    }
}
