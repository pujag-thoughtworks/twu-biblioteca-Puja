package com.twu.biblioteca;

/**
 * Describes the behaviour and features of movie.
 */
public class Movie implements Item {

    private String name;
    private String director;
    private int year;
    private MovieRating rating;

    public Movie(String name, String director, int year, MovieRating rating) {

        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getRating() {
        return rating.getRating();
    }

    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;
        if (movie == null)
            return false;
        return (name.equals(movie.name) && director.equals(movie.director) &&
                year == movie.year && this.getRating() == movie.getRating());

    }

    public String toString() {
        String representation= String.format("%-30s%-30s%-15s%-15s", name, director, year, this.getRating());
        return representation;
    }


}
