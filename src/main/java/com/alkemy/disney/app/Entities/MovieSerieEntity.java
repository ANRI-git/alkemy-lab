package com.alkemy.disney.app.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie_serie")
@Getter
@Setter
public class MovieSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String image;
    private String title;
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;
    private Long rating;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "associated_characters",
            joinColumns = @JoinColumn(name = "movie_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "associated_character_id"))
    private Set<CharacterEntity> associatedCharacters = new HashSet<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "genders",
            joinColumns = @JoinColumn(name = "movie_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id"))
    private Set<GenderEntity> genders = new HashSet<>();
}
