package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Descrobes the features of Librarian
 */
public class Librarian implements User {

    static final String USER_TYPE="librarian";

    private String name;
    private String libraryNo;
    private String password;

    public Librarian(String name, String libraryNo, String password) {
        if(!isLibraryNoInFormat(libraryNo))
            throw  new IllegalArgumentException();
        this.name=name;
        this.libraryNo=libraryNo;
        this.password=password;
    }

    private boolean isLibraryNoInFormat(String libraryNo) {
        Pattern requiredFormat = Pattern.compile("\\w{3}\\-\\w{4}");
        Matcher matcher = requiredFormat.matcher(libraryNo);
        return matcher.matches(); }

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
