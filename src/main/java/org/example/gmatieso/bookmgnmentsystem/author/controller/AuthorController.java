package org.example.gmatieso.bookmgnmentsystem.author.controller;

import org.example.gmatieso.bookmgnmentsystem.author.service.AuthorService;
import org.example.gmatieso.bookmgnmentsystem.author.dtos.AuthorRequest;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
    public List<Author> getAllAuthors(){
        return  authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
    public Optional<Author> getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    public Author createAuthor(@RequestBody AuthorRequest author){
        return authorService.createAuthor(author);
    }


}
