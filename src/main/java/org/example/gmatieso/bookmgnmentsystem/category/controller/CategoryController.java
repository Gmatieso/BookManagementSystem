package org.example.gmatieso.bookmgnmentsystem.category.controller;

import org.example.gmatieso.bookmgnmentsystem.category.dtos.CategoryRequest;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;
import org.example.gmatieso.bookmgnmentsystem.category.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Category> getAllCategories() {
       return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<Category> getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Category createCategory(@RequestBody  CategoryRequest category){
        return categoryService.createCategory(category);
    }
}
