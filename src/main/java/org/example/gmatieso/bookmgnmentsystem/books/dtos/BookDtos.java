package org.example.gmatieso.bookmgnmentsystem.books.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BookDtos {
    String title;
    String description;
    Long authorId;
    String isbn;
    int pages;
    List<Long> categoryIds;

    public BookDtos(String title, String description, Long authorId, String isbn, int pages, List<Long> categoryIds) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.isbn = isbn;
        this.pages = pages;
        this.categoryIds = categoryIds;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }


}
