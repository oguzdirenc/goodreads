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
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    private String typeName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "movieTypeSet")
    private Set<Movie> movieSet;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "tvSeriesTypeSet")
    private Set<TvSeries> tvSeriesSet;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "typeSet")
    private Set<Book> bookSet;

}
