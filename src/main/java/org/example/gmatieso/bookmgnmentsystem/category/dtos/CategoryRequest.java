package org.example.gmatieso.bookmgnmentsystem.category.dtos;

import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

import java.util.List;

public record CategoryRequest(String  name, List<Book> books) {
}
