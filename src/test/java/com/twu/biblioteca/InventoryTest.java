package com.twu.biblioteca;

import com.twu.buildingBlocks.Book;
import com.twu.buildingBlocks.Customer;
import com.twu.buildingBlocks.Movie;
import com.twu.resources.BookStorage;
import com.twu.resources.MovieStorage;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * To test librarian
 */
public class InventoryTest {

    @Test
    public void checkedOutBookShouldNotBeAvailable() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);

        inventory.checkoutItem(requestedBook.getName(), new UserDirectory().getCustomer("CUS-0001"));

        assertTrue(!availableBooks.contains(requestedBook));
    }


    @Test
    public void shouldKnowIfABookIsAvailableForCheckout() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);
        inventory.checkoutItem(requestedBook.getName(), new UserDirectory().getCustomer("CUS-0001"));

        boolean output = inventory.isItemAvailableForCheckout(requestedBook.getName());

        assertEquals(false, output);
    }

    @Test
    public void returnedBookShouldBeAvailableForCheckoutAgain() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        List<Book> availableBooks = inventory.getAvailableItems();
        Book requestedBook = availableBooks.get(0);
        Customer customer= new UserDirectory().getCustomer("CUS-0001");

        inventory.checkoutItem(requestedBook.getName(),customer );
        inventory.returnItem(requestedBook.getName(),customer);

        assertTrue(availableBooks.contains(requestedBook));
    }

    @Test
    public void shouldKnowIfABookBelongsToLibrary() {
        Inventory<Book> inventory = new Inventory<>(new BookStorage().getBookList());
        Book randomBook = new Book("xxx", "yyy", 1988);
        assertFalse(inventory.doesItemBelongsToLibrary(randomBook.getName()));
    }

    @Test
    public void ShouldGetCheckedOutDetails() {
        Inventory<Movie> movieInventory=new Inventory<>(new MovieStorage().getMovieList());
        Movie requestedMovie= movieInventory.getAvailableItems().get(0);
        Customer customer= new UserDirectory().getCustomer("CUS-0001");

        Map<Movie,Customer> expectedOutput=new HashMap<>();
        expectedOutput.put(requestedMovie,customer);

        movieInventory.checkoutItem(requestedMovie.getName().toLowerCase(),customer);

        assertEquals(expectedOutput,movieInventory.getCheckOutDetails());

    }

}
