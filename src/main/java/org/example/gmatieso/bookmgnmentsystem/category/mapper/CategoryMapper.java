package org.example.gmatieso.bookmgnmentsystem.category.mapper;

import org.example.gmatieso.bookmgnmentsystem.category.dtos.CategoryRequest;
import org.example.gmatieso.bookmgnmentsystem.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryRequest categoryToCategoryRequest(Category category);

    Category categoryRequestToCategory(CategoryRequest categoryRequest);
}
