package org.example.gmatieso.bookmgnmentsystem.service;

import org.example.gmatieso.bookmgnmentsystem.models.Category;
import org.example.gmatieso.bookmgnmentsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

   public List<Category> getBooksByCategoryName(String categoryName){
        //TODO: if we need to call a repository method that returns books  place it in BookRepository
       // TODO: or consider a custom query here if cross-repository logic is needed.
       return categoryRepository.findAll();

    }
}
