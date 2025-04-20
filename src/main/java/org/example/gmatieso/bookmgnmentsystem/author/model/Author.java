package org.example.gmatieso.bookmgnmentsystem.author.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

import java.util.List;


@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String biography;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
