package com.goodreads.goodreads.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MovieCommand {

    private Long movieId;
    private String movieName;
    private double imdb;
    private LocalDate movieUpdateDate;

    private String commentDescription;
    private String type;
    private String directorName;
    private String actorName;
    private MultipartFile image;

}
