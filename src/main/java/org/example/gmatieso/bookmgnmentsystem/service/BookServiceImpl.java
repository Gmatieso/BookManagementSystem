package org.example.gmatieso.bookmgnmentsystem.service;

import org.example.gmatieso.bookmgnmentsystem.models.Book;
import org.example.gmatieso.bookmgnmentsystem.repository.BookRepository;

import java.util.List;
import java.util.Optional;

// TODO: Lets do some dependecies injection. Lets inject the repository layer into the Service class.
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public  List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


  public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);
    }


   public  Book saveBook(Book book){
        return bookRepository.save(book);
    }

   public boolean deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
