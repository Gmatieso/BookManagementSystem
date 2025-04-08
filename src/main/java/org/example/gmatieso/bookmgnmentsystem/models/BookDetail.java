package org.example.gmatieso.bookmgnmentsystem.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private int pages;

    @OneToOne(mappedBy = "detail")
    private Book book;
}
