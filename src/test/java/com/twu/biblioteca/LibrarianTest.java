package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests Librarian
 */
public class LibrarianTest {

    @Test
    public void shouldGetLibraryNo() {
        Librarian librarian=new Librarian("Jagriti","LIB-0001","password");
        String libraryNo=librarian.getLibraryNo();
        assertEquals("LIB-0001",libraryNo);
    }

    @Test
    public void shouldGetPassword() {
        Librarian librarian=new Librarian("Jagriti","LIB-0001","password");
        String password=librarian.getPassword();
        assertEquals("password",password);
    }

    @Test
    public void shouldGetName() {
        Librarian librarian=new Librarian("Jagriti","LIB-0001","password");
        String name=librarian.getName();
        assertEquals("Jagriti",name);
    }
}
