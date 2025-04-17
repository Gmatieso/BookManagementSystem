package org.example.gmatieso.bookmgnmentsystem.controllers;

import org.example.gmatieso.bookmgnmentsystem.dtos.BookRequest;
import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.example.gmatieso.bookmgnmentsystem.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
   public List<Book> getAllBooks(){
        return bookService.getAllBooks();
   }

   @GetMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
   public Optional<Book> getBook(@PathVariable long id){
        return bookService.getBook(id);
   }

   @DeleteMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN')")
   public Boolean deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
   }



}
