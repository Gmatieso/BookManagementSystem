package org.example.gmatieso.bookmgnmentsystem.bookDetail.controller;

import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.service.BookDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookDetail")
public class BookDetailController {

    private final BookDetails bookDetailsService;

    public BookDetailController(BookDetails bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<BookDetail> getAllBookDetails() {
        return bookDetailsService.getAllBookDetails();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Optional<BookDetail> getBookDetail(@PathVariable  Long id){
        return  bookDetailsService.getBookDetail(id);
    }
}
