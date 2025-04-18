package org.example.gmatieso.bookmgnmentsystem.bookDetail.service;

import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;

import java.util.List;
import java.util.Optional;

public interface BookDetails {
    List<BookDetail> getAllBookDetails();
    Optional<BookDetail> getBookDetail(Long id);
}
