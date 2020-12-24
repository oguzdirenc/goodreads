package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.BookCommand;
import com.goodreads.goodreads.domain.*;
import com.goodreads.goodreads.service.AuthorService;
import com.goodreads.goodreads.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @RequestMapping({"/books",""})
    public String getBooks(Model model){
        model.addAttribute("Books",bookService.findAllBooks());
        model.addAttribute("Authors",authorService.getAuthorsByName());
        model.addAttribute("TopList",bookService.top5Book());

        return "book/books";
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("book",bookService.findById(Long.valueOf(id)));

        return "book/show";
    }



    @RequestMapping("/addBook")
    public String addBook(Model model){

        model.addAttribute("bookCommand",new BookCommand());

        return "book/addBook";
    }


    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute BookCommand bookCommand){
        System.out.println(bookCommand.getBookName());
        System.out.println(bookCommand.getAuthorName());

    return "redirect:/index";
    }
}
