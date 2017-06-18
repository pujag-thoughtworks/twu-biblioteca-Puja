package com.twu.biblioteca;

import com.twu.Resources.BookStorage;
import com.twu.inputOutput.OutputWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Librarian {

    BookStorage bookStorage;
    Map<String, Book> titleToBook;
    List<Book> availableBooks;

    public Librarian() {
        bookStorage = new BookStorage();
        initialize();
    }

    private void initialize() {
        availableBooks = bookStorage.getBookList();
        titleToBook = new HashMap<>();
        for (Book book : bookStorage.getBookList()) {
            String bookTitle = book.getName().toLowerCase();
            titleToBook.put(bookTitle, book);
        }
    }

    public void checkoutBook(String bookTitle) {
        Book requiredBook = titleToBook.get(bookTitle.toLowerCase());
        availableBooks.remove(requiredBook);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }


}
