package org.example.gmatieso.bookmgnmentsystem.author.dtos;

import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

import java.util.List;

public record AuthorRequest(String name, String biography, List<Book> books) {
}
