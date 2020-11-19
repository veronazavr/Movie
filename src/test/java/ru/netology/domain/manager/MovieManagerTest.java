package ru.netology.domain.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieManagerTest {

    private MovieManager manager = new MovieManager();

    private Movie first = new Movie(1, "firstUrl", "first", "thriller");
    private Movie second = new Movie(2, "secondUrl", "second", "cartoon");
    private Movie third = new Movie(3, "thirdUrl", "third", "comedy");
    private Movie fourth = new Movie(4, "fourthUrl", "fourth", "action");
    private Movie fifth = new Movie(5, "fifthUrl", "fifth", "fantasy");
    private Movie sixth = new Movie(6, "sixthUrl", "sixth", "fantastic");
    private Movie seventh = new Movie(7, "seventhUrl", "seventh", "adventures");
    private Movie eighth = new Movie(8, "eighthUrl", "eighth", "comedy");
    private Movie ninth = new Movie(9, "ninthUrl", "ninth", "historical");
    private Movie tenth = new Movie(10, "ninthUrl", "ninth", "horror");
    private Movie eleventh = new Movie(11, "eleventhUrl", "eleventh", "biography");



    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);

    }

    @Test
    public void shouldNotTenMovies() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTenMovies() {

        manager.addMovie(tenth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreThenTenMovies() {

        manager.addMovie(tenth);
        manager.addMovie(eleventh);


        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }
}