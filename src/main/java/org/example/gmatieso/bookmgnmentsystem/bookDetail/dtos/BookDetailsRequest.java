package org.example.gmatieso.bookmgnmentsystem.bookDetail.dtos;

import org.example.gmatieso.bookmgnmentsystem.books.model.Book;

public record BookDetailsRequest(String isbn, int pages, Book book) {
}
