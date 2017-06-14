package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * List the books with the necessary details
 */
public class ListAvailableBooks {

    ArrayList<Book> bookList;

    public ListAvailableBooks(ArrayList<Book> bookList) {
        this.bookList=bookList;
    }

    public String[] list() {
        String[] books=new String[bookList.size()];
        int index=0;
        for(Book book:bookList) {
            books[index]=book.toString();
        }
        return books;
    }
}
