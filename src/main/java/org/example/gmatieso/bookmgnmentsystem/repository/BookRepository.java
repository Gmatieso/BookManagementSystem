package org.example.gmatieso.bookmgnmentsystem.repository;

import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
      List<Book> findByTitle(String title);  // ! SELECT b FROM Book b WHERE b.title = :title
      List<Book> findByTitleContaining(String keyword); // ! SELECT b FROM BOOK b WHERE b.title LIKE %:keyword%.
      List<Book> findByAuthorName(String name); // ! SELECT b FROM Book b WHERE b.author.name = :name.
     @Query("SELECT b FROM  Book  b JOIN b.categories c WHERE  c.name =:categoryName")
      List<Book> findBooksByCategory(String categoryName);
}
