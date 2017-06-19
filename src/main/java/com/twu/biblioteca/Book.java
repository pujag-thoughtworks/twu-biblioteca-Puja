package com.twu.biblioteca;

/**
 * Describes a book.
 */
public class Book implements Item {
    
    private String name;
    private String author;
    private int publishingYear;

    public Book(String name, String author, int publishingYear) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%-30s%-30s%-15s", name, author, publishingYear);
    }

    public boolean equals(Object object) {
        Book book = (Book) object;
        if (book == null)
            return false;
        return (name.equals(book.name) && author.equals(book.author) && publishingYear == book.publishingYear);
    }

}
