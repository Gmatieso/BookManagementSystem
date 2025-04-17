package org.example.gmatieso.bookmgnmentsystem.service;

import org.example.gmatieso.bookmgnmentsystem.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();
    Optional<Author> getAuthor(long id);
    Author createAuthor(Author author);
    Author updateAuthor(long id, Author author);

}
