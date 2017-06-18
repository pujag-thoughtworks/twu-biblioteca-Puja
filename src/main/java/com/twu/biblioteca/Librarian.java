package com.twu.biblioteca;

import com.twu.Resources.BookStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to handle internal details of library.
 * It maintains information about book availability and what are the books belonging to library.
 */
public class Librarian {

    private BookStorage bookStorage;
    private Map<String, Book> titleToBook;
    private List<Book> availableBooks;

    public Librarian() {
        bookStorage = new BookStorage();
        initialize();
    }

    public boolean isBookAvailable(String bookName) {
        String formattedBookName = bookName.toLowerCase();
        Book requestedBook = titleToBook.getOrDefault(formattedBookName, null);

        if (requestedBook == null || !availableBooks.contains(requestedBook))
            return false;
        return true;
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
