package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.mockModels.TestConsoleWriter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests functionalities of ListAvailableBooks
 */
public class ListAvailableBooksTest {


    @Test
    public void shouldWriteAllBooksFromList() {

        BookStorage bookStorage=new BookStorage();
        ListAvailableBooks listAvailableBooks = new ListAvailableBooks();
        TestConsoleWriter consoleWriter = new TestConsoleWriter(new
                BufferedWriter(new OutputStreamWriter(System.out)));
        List<String> expectedOutput = new ArrayList<>();
        for(Book book:bookStorage.getBookList())
             expectedOutput.add(book.toString());

        listAvailableBooks.display(consoleWriter);

        assertEquals(expectedOutput, consoleWriter.getOutput());

    }


}
