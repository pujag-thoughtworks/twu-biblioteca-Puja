package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests features of movies.
 */
public class MovieTest {

    @Test
    public void shouldGetName() {
        Movie movie=new Movie("Aag","R.G Verma",2000,new MovieRating(3));
        String output=movie.getName();
        assertEquals("Aag",output);
    }

    @Test
    public void shouldGetMovieRatingValue() {
        Movie movie=new Movie("Aag","R.G Verma",2000,new MovieRating(3));
        int rating=movie.getRating();
        assertEquals(3,rating);
    }

    @Test
    public void moviesWithSameAttributesShouldBeSame() {
        Movie movie1=new Movie("Aag","R.G Verma",2000,new MovieRating(3));
        Movie movie2=new Movie("Aag","R.G Verma",2000,new MovieRating(3));
        assertEquals(movie1,movie2);
    }

    @Test
    public void shouldHaveStringRepresentation() {
        Movie movie=new Movie("Aag","R.G Verma",2000,new MovieRating(3));
        String expectedOutput=String.format("%-30s%-30s%-15s%-15s","Aag","R.G Verma",2000,3);
        assertEquals(expectedOutput,movie.toString());
    }

}
