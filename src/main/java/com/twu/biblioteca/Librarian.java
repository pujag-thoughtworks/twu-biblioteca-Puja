package com.twu.biblioteca;

/**
 * Descrobes the features of Librarian
 */
public class Librarian implements User {

    static final String USER_TYPE="librarian";

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

    @Override
    public String getType() {
        return USER_TYPE;
    }

    String getName() {
        return name;
    }
}
