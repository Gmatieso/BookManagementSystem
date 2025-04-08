package org.example.gmatieso.bookmgnmentsystem.repository;

import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
}
