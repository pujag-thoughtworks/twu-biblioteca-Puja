package com.twu.biblioteca;

import com.twu.resources.BookStorage;
import com.twu.mockModels.TestOutputWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests functionalities of ListMenuItem
 */
public class ListMenuItemTest {


    @Test
    public void shouldWriteAllBooksFromList() {

        BookStorage bookStorage = new BookStorage();
        TestOutputWriter outputWriter = new TestOutputWriter();
        ListMenuItem<Book> listBookMenuItem = new ListMenuItem<>(outputWriter, new Inventory<>(bookStorage.getBookList()));
        listBookMenuItem.setDescriptionMessage(Constants.LIST_BOOK_DESCRIPTION_MESSAGE);

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add(Constants.LIST_BOOK_DESCRIPTION_MESSAGE);
        for (Book book : bookStorage.getBookList())
            expectedOutput.add(book.toString());

        listBookMenuItem.performAction();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }




}
