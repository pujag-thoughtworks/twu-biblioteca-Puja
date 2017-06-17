package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests functionalities of ListBooksMenuItem
 */
public class ListBooksMenuItemTest {


    @Test
    public void shouldWriteAllBooksFromList() {

        BookStorage bookStorage = new BookStorage();
        TestOutputWriter consoleWriter = new TestOutputWriter();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(consoleWriter);
        List<String> expectedOutput = new ArrayList<>();
        for (Book book : bookStorage.getBookList())
            expectedOutput.add(book.toString());

        listBooksMenuItem.performAction();

        assertEquals(expectedOutput, consoleWriter.getOutput());
    }

    @Test
    public void shouldGetMenuItemsName() {

        TestOutputWriter consoleWriter = new TestOutputWriter();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(consoleWriter);

        String menuName = listBooksMenuItem.getMenuName();

        assertEquals("List available books\n", menuName);

    }


}
