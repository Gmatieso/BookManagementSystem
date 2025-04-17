package org.example.gmatieso.bookmgnmentsystem.category.repository;

import org.example.gmatieso.bookmgnmentsystem.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
