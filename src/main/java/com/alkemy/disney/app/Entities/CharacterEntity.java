package com.alkemy.disney.app.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
@Setter
@Getter
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String image;
    private Long age;
    private Long weight;
    private String story;
    @ManyToMany(mappedBy = "associatedCharacters", cascade = CascadeType.ALL)
    private List<MovieSerieEntity> moviesSeries = new ArrayList<>();

    public void addMoviesSeries(MovieSerieEntity movieSerie) {
        this.moviesSeries.add(movieSerie);
    }

    public void removeMoviesSeries(MovieSerieEntity movieSerie) {
        this.moviesSeries.remove(movieSerie);
    }
}
