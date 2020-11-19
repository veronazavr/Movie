package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    @Test
    public void shouldRemoveIfExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 1;
        Movie first = new Movie(1, 1, "first", 1);
        Movie second = new Movie(2, 2, "second", 1);
        Movie third = new Movie(3, 3, "third", 1);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {third, second, first};
//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

}