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
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private int bookPage;

    @OneToMany
    private List<Comment> bookCommentList = new ArrayList<Comment>();

    @ManyToMany
    private Set<Author> authorSet = new HashSet<Author>();

    @ManyToMany
    private Set<Publisher> publisherSet = new HashSet<Publisher>();
}
