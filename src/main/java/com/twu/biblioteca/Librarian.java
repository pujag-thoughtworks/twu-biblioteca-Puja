package com.twu.biblioteca;

import com.twu.Resources.BookStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to handle internal details of library.
 * It maintains information about book availability and what are the books belonging to library.
 */
class Librarian {

    private BookStorage bookStorage;
    private Map<String, Book> titleToBook;
    private List<Book> availableBooks;

    Librarian() {
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

    boolean isBookAvailableForCheckout(String bookName) {
        String formattedBookName = bookName.toLowerCase();
        Book requestedBook = titleToBook.getOrDefault(formattedBookName, null);

        return !(requestedBook == null || !availableBooks.contains(requestedBook));
    }

    boolean doesBookBelongsToLibrary(String bookName) {
        String formattedBookName = bookName.toLowerCase();
        if (!titleToBook.containsKey(formattedBookName))
            return false;
        Book bookToReturn = titleToBook.get(formattedBookName);
        return !availableBooks.contains(bookToReturn);
    }

    void checkoutBook(String bookTitle) {
        Book requestedBook = titleToBook.get(bookTitle.toLowerCase());
        availableBooks.remove(requestedBook);
    }

    void returnBook(String bookTitle) {
        Book bookToReturn = titleToBook.get(bookTitle.toLowerCase());
        availableBooks.add(bookToReturn);
    }

    List<Book> getAvailableBooks() {
        return availableBooks;
    }

}
