package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BookShowController {

    private final BookService bookService;

    @RequestMapping("/book/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("book",bookService.findById(Long.valueOf(id)));

        return "book/show";
    }

}
