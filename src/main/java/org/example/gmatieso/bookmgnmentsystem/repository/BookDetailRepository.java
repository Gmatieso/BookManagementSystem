package org.example.gmatieso.bookmgnmentsystem.repository;

import org.example.gmatieso.bookmgnmentsystem.models.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}
