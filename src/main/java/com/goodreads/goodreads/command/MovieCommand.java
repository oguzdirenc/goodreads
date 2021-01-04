package com.goodreads.goodreads.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MovieCommand {

    private Long movieId;

    @NotBlank(message = "Movie name should not be blank.")
    private String movieName;

    @Min(value = 0,message = "IMDB should not be under 0")
    @Max(value = 10,message = "IMDB should not be over 10")
    private double imdb;

    private LocalDate movieUpdateDate;
    private String commentDescription;
    private String type;

    @NotBlank(message = "Director name should not be blank")
    private String directorName;

    @NotBlank(message = "Actor name should not be blank")
    private String actorName;

    private MultipartFile image;

}
