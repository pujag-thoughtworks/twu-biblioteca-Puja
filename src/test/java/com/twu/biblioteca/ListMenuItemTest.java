package com.twu.biblioteca;

import com.twu.resources.BookStorage;
import com.twu.mockModels.TestOutputWriter;
import com.twu.resources.MovieStorage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests functionalities of ListMenuItem
 */
public class ListMenuItemTest {


    @Test
    public void shouldWriteAllBooksFromList() {

        BookStorage bookStorage = new BookStorage();
        TestOutputWriter outputWriter = new TestOutputWriter();
        ListMenuItem<Book> listBookMenuItem = new ListMenuItem<>(outputWriter, new Inventory<>(bookStorage.getBookList()));
        listBookMenuItem.setItemName("Books");

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Available Books are:");
        for (Book book : bookStorage.getBookList())
            expectedOutput.add(book.toString());

        listBookMenuItem.performAction();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }

    @Test
    public void shouldWriteAllMoviesFromList() {

        MovieStorage movieStorage = new MovieStorage();
        TestOutputWriter outputWriter = new TestOutputWriter();
        ListMenuItem<Movie> listMovieMenuItem = new ListMenuItem<>(outputWriter, new Inventory<>(movieStorage.getMovieList()));
        listMovieMenuItem.setItemName("movies");

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Available movies are:");
        for (Movie movie : movieStorage.getMovieList())
            expectedOutput.add(movie.toString());

        listMovieMenuItem.performAction();

        assertEquals(expectedOutput, outputWriter.getOutput());
    }




}
