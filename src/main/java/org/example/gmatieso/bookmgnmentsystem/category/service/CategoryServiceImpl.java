package org.example.gmatieso.bookmgnmentsystem.category.service;

import org.example.gmatieso.bookmgnmentsystem.category.dtos.CategoryRequest;
import org.example.gmatieso.bookmgnmentsystem.category.mapper.CategoryMapper;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;
import org.example.gmatieso.bookmgnmentsystem.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{
    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
      Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        return categoryRepository.save(category);
    }
}
