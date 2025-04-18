package org.example.gmatieso.bookmgnmentsystem.bookDetail.service;

import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.repository.BookDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsImpl implements BookDetails {

    private final BookDetailRepository  bookDetailRepository;

    public BookDetailsImpl(BookDetailRepository bookDetailRepository) {
        this.bookDetailRepository = bookDetailRepository;
    }

    @Override
    public List<BookDetail> getAllBookDetails() {

        return bookDetailRepository.findAll();
    }

    @Override
    public Optional<BookDetail> getBookDetail(Long id) {
        return bookDetailRepository.findById(id);
    }
}
