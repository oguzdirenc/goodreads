package com.goodreads.goodreads.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter
public class BookCommand {

    private Long bookId;

    @NotBlank(message = "Book name should not be blank")
    private String bookName;

    @Min(value = 0,message = "Book page should not be negative")
    private int bookPage;

    private LocalDate bookUpdateDate;

    @Min(value = 0,message = "Point should not be under 0")
    @Max(value = 10,message = "Point should not be over 10")
    private double bookPoint;


    private String authorName;
    private String commentDescription;
    private String publisherName;
    private String type;


}
