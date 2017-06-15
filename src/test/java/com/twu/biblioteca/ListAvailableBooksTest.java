package com.twu.biblioteca;

import com.twu.mockModels.TestConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests functionalities of ListAvailableBooks
 */
public class ListAvailableBooksTest {


    @Test
    public void shouldWriteAllBooksFromList() {
        ArrayList<Book> bookList=new ArrayList<>();
        Book book1=new Book("Harry Potter","JK Rowling", 2000);
        Book book2=new Book("A Walk To Remember","Nicholas Spark",1999);
        bookList.add(book1);
        bookList.add(book2);
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(bookList);
        StringWriter stringWriter=new StringWriter();
        TestConsoleWriter consoleWriter=new TestConsoleWriter(new BufferedWriter(stringWriter));
        ArrayList<String> expectedOutput=new ArrayList<>();
        expectedOutput.add(book1.toString());
        expectedOutput.add(book2.toString());

        listAvailableBooks.displayAvailableBooks(consoleWriter);

        assertEquals(expectedOutput,consoleWriter.getOutput());

    }
}
