package org.example.gmatieso.bookmgnmentsystem.service;

import jakarta.transaction.Transactional;
import org.example.gmatieso.bookmgnmentsystem.dtos.BookRequest;
import org.example.gmatieso.bookmgnmentsystem.models.Author;
import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.example.gmatieso.bookmgnmentsystem.models.BookDetail;
import org.example.gmatieso.bookmgnmentsystem.models.Category;
import org.example.gmatieso.bookmgnmentsystem.repository.AuthorRepository;
import org.example.gmatieso.bookmgnmentsystem.repository.BookDetailRepository;
import org.example.gmatieso.bookmgnmentsystem.repository.BookRepository;
import org.example.gmatieso.bookmgnmentsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// TODO: Lets do some dependecies injection. Lets inject the repository layer into the Service class.
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDetailRepository bookDetailRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, BookDetailRepository bookDetailRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailRepository = bookDetailRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
   public  List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(long id) {
        return bookRepository.findById(id);
    }


    @Override
   public  Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Boolean deleteBook(long id) {
            if(bookRepository.existsById(id)){
                bookRepository.deleteById(id);
                return true;
            }
            return false;
    }

    @Override
    @Transactional
    public Book addBookWithDetailsAndCategories(BookRequest bookRequest) {

        Optional<Author> author = Optional.ofNullable(authorRepository.findById(bookRequest.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Oops! Sorry Author not found:" + bookRequest.authorId())));


        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setDescription(bookRequest.description());
        book.setAuthor(author.get());


        BookDetail detail = new BookDetail();
        detail.setIsbn(bookRequest.isbn());
        detail.setPages(bookRequest.pages());
        detail.setBook(book); // Link to book

        book.setDetail(detail); //Bidirectional


       List<Category> categories = categoryRepository.findAllById(bookRequest.categoryIds());
       if(categories.size() != bookRequest.categoryIds().size()){
           throw new IllegalArgumentException("Oops Sorry! One or more categories not found:" + categories);
       }
       book.setCategories(categories);

       // Save book (cascades to details and categories via rlship)
        return bookRepository.save(book);
    }
}

