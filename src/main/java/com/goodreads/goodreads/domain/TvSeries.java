package com.goodreads.goodreads.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TvSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tvSeriesId;
    private String tvSeriesName;
    private int tvSeriesSeason;
    private boolean isOver;
    private double imdb;
    private LocalDate tvSeriesUpdateDate;

    @Lob
    private String thumbnail;

    @ManyToMany
    @JoinTable(name = "tvSeries_actor",
              joinColumns = {@JoinColumn(name = "tv_series_id")},
              inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> tvSeriesActorSet = new HashSet<Actor>();

    @ManyToMany
    @JoinTable(name = "tvSeries_director",
               joinColumns ={@JoinColumn(name = "tv_series_id")},
               inverseJoinColumns = {@JoinColumn(name = "director_id")})
    private Set<Director> tvSeriesDirectorSet = new HashSet<Director>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tvSeries")
    private Set<Comment> tvSeriesCommentList = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tvSeries_type",
            joinColumns ={@JoinColumn(name = "type_id")},
            inverseJoinColumns = {@JoinColumn(name = "tvSeries_id")})
    private Set<Type> tvSeriesTypeSet = new HashSet<>();

}
