package com.goodreads.goodreads.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieName;
    private String director;
    private Long imdb;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private List<Comment> commentList = new ArrayList<>();

    @ManyToMany
    private Set<Actor> actorSet =new HashSet<Actor>();

    @ManyToMany
    private Set<Director> directorSet = new HashSet<Director>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private Set<Type> movieTypeSet = new HashSet<>();

}
