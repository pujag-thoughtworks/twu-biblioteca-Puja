package com.twu.Resources;

import com.twu.biblioteca.Book;

import java.util.ArrayList;

/**
 * Initial list of Books in Biblioteca
 */
public class BookList {
    private ArrayList<Book> bookList;
    public BookList() {
        bookList=new ArrayList<>();
        bookList.add(new Book("Harry Potter","J.K Rowling",2000));
        bookList.add(new Book("The Notebook","Nicholas Spark",1999));
        bookList.add(new Book("A Walk to Remember","Nicholas Spark",1996));
        bookList.add(new Book("Concepts of Physics","H.C Verma",1985));
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
