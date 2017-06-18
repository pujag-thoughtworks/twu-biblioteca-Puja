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
        TestOutputWriter outputWriter = new TestOutputWriter();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(outputWriter, new Librarian());

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(ListBooksMenuItem.MENU_DESCRIPTION_MESSAGE);
        for (Book book : bookStorage.getBookList())
            expectedOutput.add(book.toString());

        listBooksMenuItem.performAction();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void shouldGetMenuItemsName() {

        TestOutputWriter consoleWriter = new TestOutputWriter();
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(consoleWriter, new Librarian());

        String menuName = listBooksMenuItem.getMenuName();

        assertEquals("List available books", menuName);

    }


}
