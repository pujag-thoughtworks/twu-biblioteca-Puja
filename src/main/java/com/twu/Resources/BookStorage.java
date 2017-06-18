package com.twu.Resources;

import com.twu.biblioteca.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Initial list of Books in Biblioteca
 */
public class BookStorage  {
    private ArrayList<Book> bookList;

    public BookStorage() {
        bookList=new ArrayList<>();
        bookList.add(new Book("Harry Potter","J.K Rowling",2000));
        bookList.add(new Book("The Notebook","Nicholas Spark",1999));
        bookList.add(new Book("A Walk to Remember","Nicholas Spark",1996));
        bookList.add(new Book("Concepts of Physics","H.C Verma",1985));
    }



/* TODO: implement iterator to make it iterable and enforce immutability.
    @Override
    public Iterator<Book> iterator() {
        return Collections.unmodifiableList(bookList).iterator();
    } */

    public List<Book> getBookList() {
        return new ArrayList<Book>(bookList);
    }
}
