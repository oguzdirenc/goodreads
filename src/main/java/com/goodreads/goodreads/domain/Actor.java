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
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    private String actorName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "actorSet")
    private Set<Movie> movieSet =new HashSet<Movie>();

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "tvSeriesActorSet")
    private Set<TvSeries> tvSeriesSet = new HashSet<TvSeries>();

}
