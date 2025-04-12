package org.example.gmatieso.bookmgnmentsystem.service;

import org.example.gmatieso.bookmgnmentsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBook(long id);
    Book saveBook(Book book);
    Boolean deleteBook(long id);
    Book addBookWithDetailsAndCategories(String title, String description, long authorId, String isbn, int pages, List<Long> categoryIds);
}
