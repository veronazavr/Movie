package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
public class Movie {

    private int id;
    private String imageUrl;
    private String name;
    private String genre;

    public Movie(int id, String imageUrl, String name, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.genre = genre;
    }

    public Movie(int id, int imageUrl, String name, int genre) {
    }
}
