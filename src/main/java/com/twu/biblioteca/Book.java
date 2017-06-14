package com.twu.biblioteca;

/**
 * Describes a book.
 */
public class Book {
    String name;
    String author;
    int publishingYear;

    public Book(String name, String author, int publishingYear) {
        this.name=name;
        this.author=author;
        this.publishingYear=publishingYear;
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
}
