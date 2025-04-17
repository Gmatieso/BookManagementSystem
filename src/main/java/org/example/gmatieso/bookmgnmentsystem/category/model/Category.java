package org.example.gmatieso.bookmgnmentsystem.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Book> books;

}
