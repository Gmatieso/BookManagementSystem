package org.example.gmatieso.bookmgnmentsystem.books.dtos;

import java.util.List;

public record BookRequest(String title, String description, Long authorId, String isbn, int pages, List<Long> categoryIds) {

}
