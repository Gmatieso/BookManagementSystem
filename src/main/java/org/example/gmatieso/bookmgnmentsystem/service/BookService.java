package org.example.gmatieso.bookmgnmentsystem.service;

import org.example.gmatieso.bookmgnmentsystem.dtos.BookRequest;
import org.example.gmatieso.bookmgnmentsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBook(long id);
    Boolean deleteBook(long id);
    // TODO: Refactor this method to use a dto  record and a mapper class.
    Book addBookWithDetailsAndCategories(BookRequest bookRequest);
}
