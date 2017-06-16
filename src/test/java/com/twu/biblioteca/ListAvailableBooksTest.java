package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

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
        TestOutputWriter consoleWriter = new TestOutputWriter();
        ListAvailableBooks listAvailableBooks = new ListAvailableBooks(consoleWriter);
        List<String> expectedOutput = new ArrayList<>();
        for(Book book:bookStorage.getBookList())
             expectedOutput.add(book.toString());

        listAvailableBooks.showContent();

        assertEquals(expectedOutput, consoleWriter.getOutput());
    }

    @Test
    public void shouldGetMenuItemsName() {

        TestOutputWriter consoleWriter = new TestOutputWriter();
        ListAvailableBooks listAvailableBooks=new ListAvailableBooks(consoleWriter);

        String menuName=listAvailableBooks.getMenuName();

        assertEquals("ListAvailableBooks",menuName);

    }


}
