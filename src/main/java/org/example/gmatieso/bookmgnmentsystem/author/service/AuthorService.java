package org.example.gmatieso.bookmgnmentsystem.author.service;

import org.example.gmatieso.bookmgnmentsystem.author.dtos.AuthorRequest;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();
    Optional<Author> getAuthor(long id);
    Author createAuthor(AuthorRequest authorRequest);
    Author updateAuthor(long id, AuthorRequest authorRequest);

}
