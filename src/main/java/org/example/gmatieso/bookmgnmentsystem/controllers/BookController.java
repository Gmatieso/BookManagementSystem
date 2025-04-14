package org.example.gmatieso.bookmgnmentsystem.controllers;

import org.example.gmatieso.bookmgnmentsystem.dtos.BookRequest;
import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.example.gmatieso.bookmgnmentsystem.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBookWithDetailsAndCategories(@RequestBody BookRequest request) {
        return bookService.addBookWithDetailsAndCategories(request);
    }



}
