package org.example.gmatieso.bookmgnmentsystem.category.service;

import org.example.gmatieso.bookmgnmentsystem.category.dtos.CategoryRequest;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional <Category> getCategory(Long id);
    Category createCategory(CategoryRequest categoryRequest);
}
