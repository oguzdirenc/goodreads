package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.BookCommand;
import com.goodreads.goodreads.domain.Type;
import com.goodreads.goodreads.service.AuthorService;
import com.goodreads.goodreads.service.BookService;
import com.goodreads.goodreads.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final TypeService typeService;

    @RequestMapping({"/books",""})
    public String getBooks(Model model){
        model.addAttribute("Books",bookService.findAllBooks());
        model.addAttribute("Authors",authorService.getAuthorsByName());
        model.addAttribute("TopList",bookService.top5Book());
        model.addAttribute("Type",typeService.getAllTypes());

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
    public String saveBook(@Valid @ModelAttribute BookCommand bookCommand,
                           BindingResult bindingResult,
                           Model model,
                           @RequestParam("file") MultipartFile multipartFile) throws IOException {

        if(bindingResult.hasErrors()){

            List<String> errors = new ArrayList<>();

            for (Object object : bindingResult.getFieldErrors()){
                FieldError fieldError = (FieldError)object;
                errors.add(fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);

            return "book/addBook";
        }else {
            bookService.saveBook(bookCommand,multipartFile);
            return "redirect:/index";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id, Model model){

        bookService.deleteById(Long.valueOf(id));

        return "redirect:/index";
    }

}
