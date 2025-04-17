package org.example.gmatieso.bookmgnmentsystem.books.service;

import jakarta.transaction.Transactional;
import org.example.gmatieso.bookmgnmentsystem.books.dtos.BookDtos;
import org.example.gmatieso.bookmgnmentsystem.books.dtos.BookRequest;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.example.gmatieso.bookmgnmentsystem.books.model.Book;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;
import org.example.gmatieso.bookmgnmentsystem.author.repository.AuthorRepository;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.repository.BookDetailRepository;
import org.example.gmatieso.bookmgnmentsystem.books.repository.BookRepository;
import org.example.gmatieso.bookmgnmentsystem.category.repository.CategoryRepository;
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
    public Boolean deleteBook(long id) {
            if(bookRepository.existsById(id)){
                bookRepository.deleteById(id);
                return true;
            }
            return false;
    }

    @Override
    @Transactional
    public Book addBookWithDetailsAndCategories(BookDtos bookRequest) {

        Optional<Author> author = Optional.ofNullable(authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Oops! Sorry Author not found:" + bookRequest.getAuthorId())));


        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(author.get());


        BookDetail detail = new BookDetail();
        detail.setIsbn(bookRequest.getIsbn());
        detail.setPages(bookRequest.getPages());
        detail.setBook(book); // Link to book

        book.setDetail(detail); //Bidirectional


       List<Category> categories = categoryRepository.findAllById(bookRequest.getCategoryIds());
       if(categories.size() != bookRequest.getCategoryIds().size()){
           throw new IllegalArgumentException("Oops Sorry! One or more categories not found:" + categories);
       }
       book.setCategories(categories);

       // Save book (cascades to details and categories via rlship)
        return bookRepository.save(book);
    }
}

