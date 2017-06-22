package com.twu.biblioteca;

/**
 * Created by pujag on 6/21/17.
 */
public class Librarian implements User {

    private String name;
    private String libraryNo;
    private String password;

    public Librarian(String name, String libraryNo, String password) {
        this.name=name;
        this.libraryNo=libraryNo;
        this.password=password;
    }

    @Override
    public String getLibraryNo() {
        return libraryNo;
    }

    @Override
    public String getPassword() {
        return password;
    }

    String getName() {
        return name;
    }
}
