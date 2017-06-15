package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.inputOutput.ConsoleWriter;

import java.util.ArrayList;

/**
 * List the available books with the necessary details
 */
public class ListAvailableBooks implements MenuItem {

    private ArrayList<Book> bookList;

    public ListAvailableBooks() {
        BookStorage bookStorage=new BookStorage();
        bookList=bookStorage.getBookList();
    }


    public void display(ConsoleWriter consoleWriter) {
        for(Book book:bookList)
            consoleWriter.write(book.toString());
    }

    public boolean equals(Object obj) {
        ListAvailableBooks listAvailableBooks=(ListAvailableBooks) obj;
        if(!(listAvailableBooks instanceof ListAvailableBooks))
            return false;
        return(bookList.equals(listAvailableBooks.bookList));
    }
}
