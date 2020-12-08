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
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actorSet =new HashSet<Actor>();

    @ManyToMany
    @JoinTable(name = "movie_director",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")})
    private Set<Director> directorSet = new HashSet<Director>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private Set<Type> movieTypeSet = new HashSet<>();

}
