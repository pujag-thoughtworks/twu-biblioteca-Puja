package com.twu.buildingBlocks;

import com.twu.buildingBlocks.MovieRating;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests features of movieRating.
 */
public class MovieRatingTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotHaveValueBetweenOneAndTen() {
        MovieRating movieRating = new MovieRating(11);
    }

    @Test
    public void unratedMoviesWillHaveRatingZero() {
        MovieRating movieRating = new MovieRating();
        assertEquals(0, movieRating.getRating());
    }

}
