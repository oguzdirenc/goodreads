package com.goodreads.goodreads.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MovieCommand {

    private Long movieId;
    private String movieName;
    private Long imdb;
    private LocalDate movieUpdateDate;

    private String commentDescription;
    private String type;
    private String directorName;
    private String actorName;

}
