package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaMovieManagerWithRepositoryDefaultTest {
    @ExtendWith(MockitoExtension.class)
    public class AfishaMovieManagerWithRepositoryTestDefaul {


        @Mock
        private AfishaMovieRepository movieRepository;

        @InjectMocks
        private AfishaMovieManagerWithRepository movieManagerWithRepository;
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

        @Test
        public void shouldRemoveMovieById() {
            int idToRemove = 5;
            Movie[] returned = new Movie[]{first, second, third, fourth, sixth, seventh, eighth, ninth};

            doReturn(returned).when(movieRepository).findAll();
            doNothing().when(movieRepository).removeById(idToRemove);

            movieManagerWithRepository.removeById(idToRemove);
            Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fourth, third, second, first};
            Movie[] actual = movieManagerWithRepository.getLastMovies();

            assertArrayEquals(expected, actual);

            verify(movieRepository).removeById(idToRemove);
        }

        @Test
        public void shouldGetLessThenTenMovies() {
            Movie[] returned = new Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};

            doReturn(returned).when(movieRepository).findAll();

            Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
            Movie[] actual = movieManagerWithRepository.getLastMovies();

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldGetTenMovies() {
            Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};

            doReturn(returned).when(movieRepository).findAll();

            Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
            Movie[] actual = movieManagerWithRepository.getLastMovies();

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldGetMoreThenTenMovies() {

            Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                    eleventh};

            doReturn(returned).when(movieRepository).findAll();

            Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
            Movie[] actual = movieManagerWithRepository.getLastMovies();

            assertArrayEquals(expected, actual);
        }


    }
    }
