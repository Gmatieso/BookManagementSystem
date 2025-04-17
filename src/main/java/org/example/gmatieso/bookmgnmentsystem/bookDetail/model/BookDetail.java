package org.example.gmatieso.bookmgnmentsystem.bookDetail.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

@Getter
@Entity
@Setter
@Data
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private int pages;

    @OneToOne(mappedBy = "detail")
    private Book book;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setBook(Book book) {
        this.book = book;
    }






}
