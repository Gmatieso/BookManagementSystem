package org.example.gmatieso.bookmgnmentsystem.author.mappers;

import org.example.gmatieso.bookmgnmentsystem.author.dtos.AuthorRequest;
import org.example.gmatieso.bookmgnmentsystem.author.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorRequest authorToAuthorRequest(Author author);

    Author authorRequestToAuthor(AuthorRequest authorRequest);
}
