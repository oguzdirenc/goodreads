package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.domain.Book;
import com.goodreads.goodreads.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping({"/book/books","/books"})
    public String getBooks(Model model){
        model.addAttribute("Books",bookService.findAllBooks());
        model.addAttribute("Last4Book",bookService.getLast4Book());

        return "book/books";
    }

}
