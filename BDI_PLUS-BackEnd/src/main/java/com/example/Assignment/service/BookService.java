package com.example.Assignment.service;

import com.example.Assignment.common.BaseResponse;
import com.example.Assignment.common.BookDto;

public interface BookService {
    BaseResponse addNewBook(BookDto books);

    BaseResponse fetchBookById(int bookId);

    BaseResponse updateBookById(int bookId, BookDto bookDto);

    BaseResponse fetchAllBooks();

    BaseResponse deleteBookById(int bookId);
}
