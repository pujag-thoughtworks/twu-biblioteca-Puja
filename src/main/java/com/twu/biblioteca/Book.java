package com.twu.biblioteca;

/**
 * Describes a book.
 */
public class Book {
    String name;
    String author;
    int publishingYear;

    public Book(String name, String author, int publishingYear) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String toString() {
        String bookRepresentation = String.format("%-30s%-30s%-15s",name,author,publishingYear);
        return bookRepresentation;
    }

    public boolean equals(Object object){
       Book book=(Book) object;
       if(!(book instanceof Book))
           return false;
       return (name.equals(book.name) && author.equals(book.author) && publishingYear==book.publishingYear);
    }
}
