package com.twu.biblioteca;

import com.twu.mockModels.TestInputReader;
import com.twu.mockModels.TestOutputWriter;
import com.twu.resources.BookStorage;
import com.twu.resources.MovieStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * tests features of checkOutBookMenuItem
 */
public class CheckOutMenuItemTest {

    @Test
    public void shouldDisplayCheckOutStatusForBook() {

        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        Book requestedBook = inventory.getAvailableItems().get(0);
        String bookName = requestedBook.getName();

        TestInputReader inputReader = new TestInputReader(bookName + "\n" + bookName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        CheckOutMenuItem<Book> checkOutMenuItem = new CheckOutMenuItem<>(inputReader, outputWriter, inventory, null);
        checkOutMenuItem.setDisplayMessage(Constants.MESSAGE_TO_REQUEST_CHECKOUT_BOOK,
                Constants.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE,Constants.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE);

        checkOutMenuItem.performAction();
        checkOutMenuItem.performAction();

        assertEquals(Constants.SUCCESSFUL_CHECKOUT_BOOK_MESSAGE, outputWriter.getOutput().get(1));
        assertEquals(Constants.UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE, outputWriter.getOutput().get(3));
    }

    @Test
    public void shouldDisplayCheckOutStatusForMovies() {

        Inventory<Movie> inventory = new Inventory<>(new MovieStorage().getMovieList());
        Movie requestedMovie = inventory.getAvailableItems().get(0);
        String movieName = requestedMovie.getName();

        TestInputReader inputReader = new TestInputReader(movieName + "\n" + movieName);
        TestOutputWriter outputWriter = new TestOutputWriter();
        CheckOutMenuItem<Movie> checkOutMovie = new CheckOutMenuItem<>(inputReader, outputWriter, inventory, null);
        checkOutMovie.setDisplayMessage(Constants.MESSAGE_TO_REQUEST_CHECKOUT_MOVIE,
                Constants.UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE,Constants.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE);

        checkOutMovie.performAction();
        checkOutMovie.performAction();

        assertEquals(Constants.SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE, outputWriter.getOutput().get(1));
        assertEquals(Constants.UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE, outputWriter.getOutput().get(3));
    }


}
