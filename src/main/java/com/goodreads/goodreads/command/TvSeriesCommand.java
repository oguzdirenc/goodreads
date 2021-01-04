package com.goodreads.goodreads.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TvSeriesCommand {


    private Long tvSeriesId;

    @NotBlank(message = "TvSeries name should not be blank")
    private String tvSeriesName;

    @Min(value = 0,message = "TvSeries season should not be negative number")
    private int tvSeriesSeason;

    private Boolean isOver;

    @Min(value = 0,message = "IMDB should not be under 0")
    @Max(value = 10,message = "IMDB should not be over 10")
    private double imdb;

    private LocalDate tvSeriesUpdateDate;

    private MultipartFile image;

    @NotBlank(message = "Actor name should not be blank")
    private String actorName;

    @NotBlank(message = "Director name should not be blank")
    private String directorName;

    private String commentDescription;

    private String type;



}
