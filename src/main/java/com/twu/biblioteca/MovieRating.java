package com.twu.biblioteca;

/**
 * It represents movie Rating.
 */
public class MovieRating {
    int rating;

    MovieRating(int i) {
        if (i > 10 || i < 1)
            throw new IllegalArgumentException();
        rating = i;
    }

    MovieRating() {
        rating = 0;
    }

    int getRating() {
        return rating;
    }


}
