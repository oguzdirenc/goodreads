package com.goodreads.goodreads.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;
    private String directorName;
    private String directorFirstName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "directorSet")
    private Set<Movie> movieSet =new HashSet<Movie>();

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "tvSeriesDirectorSet")
    private Set<TvSeries> tvSeriesSet = new HashSet<TvSeries>();

}
