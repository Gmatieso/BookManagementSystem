package org.example.gmatieso.bookmgnmentsystem.books.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;

import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    private Author author;

    private String description;

    @ManyToMany
    @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private BookDetail detail;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories(List<Category> categories) {this.categories = categories;}

    public void setDetail(BookDetail detail) {this.detail = detail;}


}
