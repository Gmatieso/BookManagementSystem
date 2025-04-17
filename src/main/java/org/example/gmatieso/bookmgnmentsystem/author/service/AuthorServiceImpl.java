package org.example.gmatieso.bookmgnmentsystem.author.service;

import org.example.gmatieso.bookmgnmentsystem.author.dtos.AuthorRequest;
import org.example.gmatieso.bookmgnmentsystem.author.mappers.AuthorMapper;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.example.gmatieso.bookmgnmentsystem.author.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthor(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        Author author = authorMapper.authorRequestToAuthor(authorRequest);
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(long id, AuthorRequest updatedAuthor) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Oops! Sorry Author not found:" + id));
        author.setName(updatedAuthor.name());
        author.setBiography(updatedAuthor.biography());
        return authorRepository.save(author);
    }
}
