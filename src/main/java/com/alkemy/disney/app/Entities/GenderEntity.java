package com.alkemy.disney.app.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gender")
@Setter
@Getter
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "genders", cascade = CascadeType.ALL)
    private List<MovieSerieEntity> moviesSeries = new ArrayList<>();

    public void addMoviesSeries(MovieSerieEntity movieSerie) {
        this.moviesSeries.add(movieSerie);
    }

    public void removeMoviesSeries(MovieSerieEntity movieSerie) {
        this.moviesSeries.remove(movieSerie);
    }
}
