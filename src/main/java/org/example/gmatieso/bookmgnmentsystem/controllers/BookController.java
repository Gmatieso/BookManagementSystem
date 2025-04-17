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

    /**
     * A service responsible for handling business logic related to book management.
     * This includes operations such as adding books with details and categories,
     * retrieving books, and deleting them.
     *
     * Used within the {@link BookController} to delegate book-related operations.
     */
    private final BookService bookService;

    /**
     * Constructor for the BookController class.
     * Initializes the BookController with the given BookService instance.
     *
     * @param bookService the service responsible for managing book-related operations
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Adds a new book with its details and associated categories based on the provided request.
     *
     * @param request the request containing book details including title, description, author ID, ISBN,
     *                number of pages, and list of category IDs
     * @return the newly created book with populated details and associated categories
     */
    @PostMapping
    public Book addBookWithDetailsAndCategories(@RequestBody BookRequest request) {
        return bookService.addBookWithDetailsAndCategories(request);
    }

    /**
     * Retrieves a list of all books.
     *
     * @return a list of all available Book objects
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
   public List<Book> getAllBooks(){
        return bookService.getAllBooks();
   }

   /**
    * Retrieves a book with the specified ID.
    *
    * @param id the ID of the book to retrieve
    * @return an Optional containing the Book if found, or an empty Optional if no book is found with the given ID
    */
   @GetMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN') or  hasRole('USER')")
   public Optional<Book> getBook(@PathVariable long id){
        return bookService.getBook(id);
   }

   /**
    * Deletes a book with the given ID. This operation is restricted to users with the 'ADMIN' role.
    *
    * @param id the ID of the book to be deleted
    * @return true if the book was successfully deleted, false otherwise
    */
   @DeleteMapping("/{id}")
   @PreAuthorize("hasRole('ADMIN')")
   public Boolean deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
   }



}
