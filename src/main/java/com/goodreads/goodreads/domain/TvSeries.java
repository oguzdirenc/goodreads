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
public class TvSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tvSeriesId;
    private String tvSeriesName;
    private int tvSeriesSeason;
    private boolean isOver;
    private double imdb;

    @ManyToMany
    private Set<Actor> tvSeriesActorSet = new HashSet<Actor>();

    @ManyToMany
    private Set<Director> tvSeriesDirectorSet = new HashSet<Director>();

    @OneToMany
    private List<Comment> tvSeriesCommentList = new ArrayList<Comment>();

}
