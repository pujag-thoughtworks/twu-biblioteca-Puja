package com.twu.resources;

import com.twu.buildingBlocks.Movie;
import com.twu.buildingBlocks.MovieRating;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage for book
 * Depends on movie
 */
public class MovieStorage {
    private List<Movie> movieList;

    public MovieStorage() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("If Only", "G Junger", 2004, new MovieRating(7)));
        movieList.add(new Movie("Aag", "R.G Verma", 2004, new MovieRating(3)));
        movieList.add(new Movie("NH 10", "A Kashyap", 2016, new MovieRating(8)));
        movieList.add(new Movie("Gravity", "A Cuaron", 2003, new MovieRating(9)));
    }

    public List<Movie> getMovieList() {
        return new ArrayList<>(movieList);
    }

}
