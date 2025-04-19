package org.example.gmatieso.bookmgnmentsystem.bookDetail.mappers;

import org.example.gmatieso.bookmgnmentsystem.bookDetail.dtos.BookDetailsRequest;
import org.example.gmatieso.bookmgnmentsystem.bookDetail.model.BookDetail;

public interface BookDetailMapper {
    BookDetailsRequest bookDetailToBookDetailRequest(BookDetail bookDetail);

    BookDetail bookDetailRequestToBookDetail(BookDetailsRequest bookDetailRequest);
}
