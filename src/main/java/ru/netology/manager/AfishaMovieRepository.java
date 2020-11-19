package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaMovieRepository {


    private Movie[] movies = new Movie[0];

    //    добавляет фильм в массив
    public void saveMovie(Movie addedMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastMovieIndex = tmp.length - 1;
        tmp[lastMovieIndex] = addedMovie;
        movies = tmp;
    }

    // возвращает массив всех хранящихся в массиве фильмов
    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findById(int id) {
        int length = 1;
        Movie[] findId = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                findId[index] = movie;
                index++;
            }
        }
        return findId;
    }

    public void removeById(int idToRemove) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != idToRemove) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Movie[] removeAll() {
        return movies = new Movie[] {};
    }
}

