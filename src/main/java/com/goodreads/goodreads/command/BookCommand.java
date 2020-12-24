package com.goodreads.goodreads.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter
public class BookCommand {

    private Long bookId;
    private String bookName;
    private int bookPage;
    private LocalDate bookUpdateDate;
    private double bookPoint;


    private String authorName;
    private String commentDescription;
    private String publisherName;
    private String type;


}
