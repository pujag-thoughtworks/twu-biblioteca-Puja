package com.twu.biblioteca;

import com.twu.buildingBlocks.Customer;
import com.twu.buildingBlocks.Movie;
import com.twu.mockModels.TestOutputWriter;
import com.twu.resources.MovieStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests checkedOutDetailsMenuItem
 */
public class CheckedOutDetailsMenuItemTest {

    @Test
    public void shouldDisplayDetailsOFCheckedOutItems() {
        TestOutputWriter outputWriter=new TestOutputWriter();
        Inventory<Movie> movieInventory=new Inventory<>(new MovieStorage().getMovieList());

        Movie checkedOutMovie=movieInventory.getAvailableItems().get(0);
        Customer customer=new UserDirectory().getCustomer("CUS-0001");
        String expectedOutput=checkedOutMovie.getName()+ " " +("CUS-0001");

        CheckedOutDetailsMenuItem<Movie> movieCheckedOutDetailsMenuItem=new CheckedOutDetailsMenuItem<>(outputWriter,movieInventory);
        movieInventory.checkoutItem(checkedOutMovie.getName(),customer);
        movieCheckedOutDetailsMenuItem.performAction();

        assertEquals(expectedOutput,outputWriter.getOutput().get(0));
    }
}
