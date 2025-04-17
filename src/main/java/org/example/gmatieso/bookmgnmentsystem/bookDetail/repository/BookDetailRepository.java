package org.example.gmatieso.bookmgnmentsystem.bookDetail.repository;

import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}
