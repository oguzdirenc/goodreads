package com.goodreads.goodreads.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
    private LocalDate bookUpdateDate;
    private double bookPoint;

    @Lob
    private String thumbnail;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private Set<Comment> bookCommentList = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authorSet = new HashSet<Author>();

    @ManyToMany
    @JoinTable(name = "book_publisher",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher> publisherSet = new HashSet<Publisher>();

    @ManyToMany
    @JoinTable(name = "book_type",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")})
    private List<Type> typeSet = new ArrayList<>();
}
