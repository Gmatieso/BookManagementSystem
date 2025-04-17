package org.example.gmatieso.bookmgnmentsystem.books.mappers;

import org.example.gmatieso.bookmgnmentsystem.books.dtos.BookDtos;
import org.example.gmatieso.bookmgnmentsystem.books.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDtos bookToBookDto(Book book);

    Book bookDtoToBook(BookDtos bookDtos);

}
