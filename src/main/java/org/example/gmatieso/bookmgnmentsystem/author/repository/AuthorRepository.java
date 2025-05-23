package org.example.gmatieso.bookmgnmentsystem.author.repository;

import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
